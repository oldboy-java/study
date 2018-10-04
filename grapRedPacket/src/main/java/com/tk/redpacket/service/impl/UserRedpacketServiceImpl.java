package com.tk.redpacket.service.impl;


import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tk.redpacket.mapper.UserRedPacketMapper;
import com.tk.redpacket.pojo.RedPacket;
import com.tk.redpacket.pojo.UserRedPacket;
import com.tk.redpacket.service.IRedpacketService;
import com.tk.redpacket.service.IUserRedpacketService;
import com.tk.redpacket.util.FileUtils;

import redis.clients.jedis.Jedis;

/**
 * 抢红包服务实现类
 */
@Service("userRedpacketService")
public class UserRedpacketServiceImpl implements IUserRedpacketService {
    @Autowired
    private UserRedPacketMapper userRedPacketMapper;

    @Autowired
    private IRedpacketService redpacketService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    /**
     * 生成抢红包信息
     *
     * @param redPacketId 红包编号
     * @param userId      抢红包用户编号
     * @return 返回影响的行数
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer grabUserRedPacket(Integer redPacketId, Integer userId) {
        //获取红包信息
        RedPacket redPacket = redpacketService.schRedPacketById(redPacketId);

        //剩余红包数大于0
        if (redPacket.getStock() > 0) {
            //扣减红包库存
            redpacketService.decreaseRedPacket(redPacketId);

            //构造抢红包信息
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setGrabTime(new Date());
            userRedPacket.setUserId(userId);
            userRedPacket.setRedPacketId(redPacketId);
            userRedPacket.setAmount(redPacket.getUnitAmount());
            userRedPacket.setNote("用户【" + userId + "】抢红包【" + redPacketId + "】");
            //生成抢红包信息
            return userRedPacketMapper.addUserRedPacket(userRedPacket);
        } else {
            return 0;
        }
    }

    /**
     * 生成抢红包信息(使用数据库悲观锁机制)
     *
     * @param redPacketId 红包编号
     * @param userId      抢红包用户编号
     * @return 返回影响的行数
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer grabUserRedPacketForUpdate(Integer redPacketId, Integer userId) {
        //获取红包信息
        //使用悲观锁实现
        RedPacket redPacket = redpacketService.schRedPacketByIdForUpdate(redPacketId);

        //剩余红包数大于0
        if (redPacket.getStock() > 0) {
            //扣减红包库存
            redpacketService.decreaseRedPacket(redPacketId);

            //构造抢红包信息
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setGrabTime(new Date());
            userRedPacket.setUserId(userId);
            userRedPacket.setRedPacketId(redPacketId);
            userRedPacket.setAmount(redPacket.getUnitAmount());
            userRedPacket.setNote("用户【" + userId + "】抢红包【" + redPacketId + "】");
            //生成抢红包信息
            return userRedPacketMapper.addUserRedPacket(userRedPacket);
        } else {
            return 0;
        }
    }

    /**
     * 生成抢红包信息（使用乐观锁机制+重试机制）
     *
     * @param redPacketId 红包编号
     * @param userId      抢红包用户编号
     * @return 返回影响的行数
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer grabUserRedPacketForVersion(Integer redPacketId, Integer userId) {
        for (int i = 0; i < 3; i++) {
            //获取红包信息
            RedPacket redPacket = redpacketService.schRedPacketById(redPacketId);

            //剩余红包数大于0
            if (redPacket.getStock() > 0) {
                //扣减红包库存
                //使用保存的version旧值传递SQL判断是否数据已经被修改
                int update = redpacketService.decreaseRedPacketForVersion(redPacketId, redPacket.getVersion());
                //返回结果为0，说明数据已经被其他线程修改，本次抢红包失败，重新抢夺
                if (update == 0) {
                    continue;
                }

                //构造抢红包信息
                UserRedPacket userRedPacket = new UserRedPacket();
                userRedPacket.setGrabTime(new Date());
                userRedPacket.setUserId(userId);
                userRedPacket.setRedPacketId(redPacketId);
                userRedPacket.setAmount(redPacket.getUnitAmount());
                userRedPacket.setNote("用户【" + userId + "】抢红包【" + redPacketId + "】");
                //生成抢红包信息
                return userRedPacketMapper.addUserRedPacket(userRedPacket);
            } else {//无库存，返回失败
                return 0;
            }
        }
        return 0;//重试三次未成功，返回失败
    }

    
    private byte[] sha1;
    
    /**
     * 生成抢红包信息（redis实现）
     *
     * @param redPacketId 红包编号
     * @param userId      抢红包用户编号
     * @return 返回影响的行数
     */
	@Override
	public Integer grabUserRedPacketByRedis(Integer redPacketId, Integer userId) {
		Integer result = null;
		//当前抢红包用户和日期
		String args = userId+"-"+System.currentTimeMillis();
		
		//获取Jedis对象
		Jedis jedis = (Jedis)redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		
		//获取lua脚本文件字节数组
		InputStream inputStream = UserRedPacket.class.getClassLoader().getResourceAsStream("grab_red_packet.lua");
		byte[] bytes = FileUtils.getInputStreamByte(inputStream);
		
		try {
			//未加载lua脚本,加载脚本
			if(sha1 == null) {
				sha1 = jedis.scriptLoad(bytes);
			}
			//执行脚本
			Object res = jedis.evalsha(sha1,1,String.valueOf(redPacketId).getBytes(),args.getBytes());
			result = ((Long)res).intValue();
			
			//返回2，则需要进行数据库保存操作
			if(result == 2) {
				//获取单个红包金额
				String unitMountStr = jedis.hget("red_packet_" + redPacketId, "unit_amount");
				BigDecimal unitAmount = BigDecimal.valueOf(Double.parseDouble(unitMountStr));
				redpacketService.saveUserRedPacket2Db(redPacketId, unitAmount);
			}
			
		} finally {
			if (jedis !=null && jedis.isConnected()) {
				jedis.close();
			}
		}
		
		return result;
	}
}
