package com.tk.redpacket.service;

import com.tk.redpacket.pojo.RedPacket;

import java.math.BigDecimal;

/**
 * 红包服务接口
 */
public interface IRedpacketService {

    /**
     * 获取红包
     *
     * @param id 编号
     * @return 红包信息
     */
    public RedPacket schRedPacketById(Integer id);

    /**
     * 获取红包(for update 语句加锁)
     *
     * @param id 编号
     * @return 红包信息
     */
    public RedPacket schRedPacketByIdForUpdate(Integer id);

    /**
     * 扣减红包
     *
     * @param id 编号
     * @return 影响行数
     */
    public int decreaseRedPacket(Integer id);

    /**
     * 扣减红包(使用版本号)
     *
     * @param id      编号
     * @param version 版本号
     * @return 影响行数
     */
    public int decreaseRedPacketForVersion(Integer id, Integer version);

    /**
     * 保存抢红包信息到数据库
     *
     * @param redPacketId 红包ID
     * @param unitAmount  单个红包金额
     */
    public void saveUserRedPacket2Db(Integer redPacketId, BigDecimal unitAmount);
}
