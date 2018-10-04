package com.tk.redpacket.mapper;

import com.tk.redpacket.pojo.UserRedPacket;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 用户抢红包表实体映射
 */
@Mapper
public interface UserRedPacketMapper {

    /**
     * UserRedPacket的主键查询方法
     *
     * @param id 主键值
     * @return 返回UserRedPacket实体
     */
    public UserRedPacket schUserRedPacketById(Integer id);

    /**
     * UserRedPacket的添加方法
     *
     * @param userRedPacket 承载数据的Bean，执行添加后会更新入库后的主键值
     * @return 返回影响的行数
     */
    public Integer addUserRedPacket(UserRedPacket userRedPacket);
}
