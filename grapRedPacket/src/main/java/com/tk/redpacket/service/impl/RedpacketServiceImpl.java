package com.tk.redpacket.service.impl;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.tk.redpacket.mapper.RedPacketMapper;
import com.tk.redpacket.pojo.RedPacket;
import com.tk.redpacket.pojo.UserRedPacket;
import com.tk.redpacket.service.IRedpacketService;

import lombok.extern.slf4j.Slf4j;

/**
 * 红包服务实现类
 */
@Service("redpacketService")
@Slf4j
public class RedpacketServiceImpl implements IRedpacketService {

    @Autowired
    private RedPacketMapper redPacketMapper;


    @Override
    public RedPacket schRedPacketById(Integer id) {
        return redPacketMapper.schRedPacketById(id);
    }

    @Override
    public RedPacket schRedPacketByIdForUpdate(Integer id) {
        return redPacketMapper.schRedPacketByIdForUpdate(id);
    }

    @Override
    public int decreaseRedPacket(Integer id) {
        return redPacketMapper.decreaseRedPacket(id);
    }

    @Override
    public int decreaseRedPacketForVersion(Integer id, Integer version) {
        return redPacketMapper.decreaseRedPacketForVersion(id, version);
    }

    private static final String PREFIX = "red_packet_list_";
    
    //每次取1000条数据，避免一次取出消耗太多内存
    private static final Integer TIME_SIZE = 1000;
    
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private DataSource dataSource;

    @Override
    @Async
    public void saveUserRedPacket2Db(Integer redPacketId, BigDecimal unitAmount) {
        log.debug("红包ID=【{}】,抢红包金额=【{}】",redPacketId,unitAmount);
        Long start = System.currentTimeMillis();

        //获取抢红包列表
        BoundListOperations<String,String>  ops = redisTemplate.boundListOps(PREFIX+redPacketId);
        //获取列表大小
        Long size = ops.size();

        //计算处理次数
        Long times = size % TIME_SIZE == 0 ? size /TIME_SIZE:size /TIME_SIZE +1;
        int count = 0;
        List<UserRedPacket> userRedPackets = new ArrayList<>(TIME_SIZE);

        for(int i = 0 ;i <times;i++){
            List<String> userIdList = null;
            if(i == 0) {
                userIdList = ops.range(i*TIME_SIZE,(i+1)*TIME_SIZE);
            }else{
                userIdList = ops.range(i*TIME_SIZE +1,(i+1)*TIME_SIZE);
            }

            //清空
            userRedPackets.clear();

            //解析红包信息
            for(int j=0 ;j<userIdList.size();j++){
                String args = userIdList.get(j);
                String arr[] = args.split("-");
                String userIdStr = arr[0]; //抢用户ID
                String timeStr = arr[1]; //抢红包时间
                Integer userId = Integer.parseInt(userIdStr);
                Long time = Long.parseLong(timeStr);

                //构造抢红包信息
                UserRedPacket userRedPacket = new UserRedPacket();
                userRedPacket.setAmount(unitAmount);
                userRedPacket.setRedPacketId(redPacketId);
                userRedPacket.setUserId(userId);
                userRedPacket.setGrabTime(new Date(time));
                userRedPacket.setNote("抢红包："+redPacketId);
                userRedPackets.add(userRedPacket);
            }
            //插入抢红包信息
            count +=executeBatch(userRedPackets);
        }

        //删除Redis抢红包列表缓存
        redisTemplate.delete(PREFIX + redPacketId);
        //删除Redis红包缓存
        redisTemplate.delete("red_packet_"+redPacketId);
        
        Long end  = System.currentTimeMillis();
        log.info("保存数据结束，总耗时：" + (end - start)+"毫秒，共"+count +"调记录保存");
    }

    /***
     * 使用JDBC批量处理Redis缓存数据
     * @param userRedPackets 抢红包列表
     * @return 抢红包插入数量
     */
    private int executeBatch(List<UserRedPacket> userRedPackets) {
        Connection conn = null;
        Statement stmt = null;
        int[] count = null;
        try  {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(UserRedPacket userRedPacket: userRedPackets){
                String sql1 = "update t_red_packet set stock=stock-1 where id =" +userRedPacket.getRedPacketId();
                String sql2 = "insert into t_user_red_packet (red_packet_id,user_id,amount,grab_time,note) values("+
                        userRedPacket.getRedPacketId()+","+userRedPacket.getUserId()+"," + userRedPacket.getAmount() +",'" +
                        sdf.format(userRedPacket.getGrabTime())+"','" + userRedPacket.getNote() +"')";
                stmt.addBatch(sql1);
                stmt.addBatch(sql2);
            }
            //执行批量操作
            count = stmt.executeBatch();

            //提交事务
            conn.commit();

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("抢红包批量执行保存错误");
        }finally {
            try{
                if(conn !=null && !conn.isClosed()) {
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        //返回插入抢红包记录数
        return count.length /2;
    }
}//end
