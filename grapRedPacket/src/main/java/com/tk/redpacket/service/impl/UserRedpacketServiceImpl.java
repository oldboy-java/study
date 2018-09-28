package com.tk.redpacket.service.impl;


import com.tk.redpacket.mapper.RedPacketMapper;
import com.tk.redpacket.mapper.UserRedPacketMapper;
import com.tk.redpacket.pojo.RedPacket;
import com.tk.redpacket.pojo.UserRedPacket;
import com.tk.redpacket.service.IRedpacketService;
import com.tk.redpacket.service.IUserRedpacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/** 抢红包服务实现类 */
@Service("userRedpacketService")
public class UserRedpacketServiceImpl implements IUserRedpacketService {
	@Autowired
	private UserRedPacketMapper userRedPacketMapper;

	@Autowired
	private IRedpacketService redpacketService;

	/**
	 * 生成抢红包信息
	 *@param  redPacketId 红包编号
	 *@param  userId 抢红包用户编号
	 * @return 返回影响的行数
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public Integer grabUserRedPacket(Integer redPacketId, Integer userId) {
		//获取红包信息
		RedPacket redPacket = redpacketService.schRedPacketById(redPacketId);
		//使用悲观锁实现
		//RedPacket redPacket = redpacketService.schRedPacketByIdForUpdate(redPacketId);
		if(redPacket == null){
			return 0;
		}
		//剩余红包数大于0
		if(redPacket.getStock() > 0) {
			//扣减红包库存
			redpacketService.decreaseRedPacket(redPacketId);

			//构造抢红包信息
			UserRedPacket userRedPacket = new UserRedPacket();
			userRedPacket.setGrabTime(new Date());
			userRedPacket.setUserId(userId);
			userRedPacket.setRedPacketId(redPacketId);
			userRedPacket.setAmount(redPacket.getUnitAmount());
			userRedPacket.setNote("用户【"+userId+"】抢红包【"+redPacketId+"】");
			//生成抢红包信息
			return userRedPacketMapper.addUserRedPacket(userRedPacket);
		}else {
			return 0;
		}
	}
}
