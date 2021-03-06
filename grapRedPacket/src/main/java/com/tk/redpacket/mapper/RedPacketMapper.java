package com.tk.redpacket.mapper;

import com.tk.redpacket.pojo.RedPacket;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 红包表实体映射
 */
@Mapper
public interface RedPacketMapper {

    /**
     * 获取红包信息
     *
     * @param id 编号
     * @return 返回红包信息
     */
    public RedPacket schRedPacketById(Integer id);


    /***
     * 扣减红包数
     * @param id 红包编号
     * @return 更新记录行数
     */
    public int decreaseRedPacket(Integer id);

    /***
     * 扣减红包数(使用Version -乐观锁实现)
     * @param id 红包编号
     * @return 更新记录行数
     */
    public int decreaseRedPacketForVersion(@Param("id") Integer id, @Param("version") Integer version);


    /**
     * 获取红包信息(for update 语句进行加锁)
     *
     * @param id 编号
     * @return 返回红包信息
     */
    public RedPacket schRedPacketByIdForUpdate(Integer id);
}
