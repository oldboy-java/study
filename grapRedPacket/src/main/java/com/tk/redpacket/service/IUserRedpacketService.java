package com.tk.redpacket.service;

/**
 * 抢红包服务接口
 */
public interface IUserRedpacketService {

    /**
     * 生成抢红包信息
     *
     * @param redPacketId 红包编号
     * @param userId      抢红包用户编号
     * @return 返回影响的行数
     */
    public Integer grabUserRedPacket(Integer redPacketId, Integer userId);

    /**
     * 生成抢红包信息(数据库悲观锁实现)
     *
     * @param redPacketId 红包编号
     * @param userId      抢红包用户编号
     * @return 返回影响的行数
     */
    public Integer grabUserRedPacketForUpdate(Integer redPacketId, Integer userId);


    /**
     * 生成抢红包信息 （基于版本号乐观锁）
     *
     * @param redPacketId 红包编号
     * @param userId      抢红包用户编号
     * @return 返回影响的行数
     */
    public Integer grabUserRedPacketForVersion(Integer redPacketId, Integer userId);
    
    
    /**
     * 生成抢红包信息（redis实现）
     *
     * @param redPacketId 红包编号
     * @param userId      抢红包用户编号
     * @return 返回影响的行数
     */
    public Integer grabUserRedPacketByRedis(Integer redPacketId, Integer userId);

}
