package com.liuli.event.mapper;

import com.liuli.event.pojo.TMsg;
import com.liuli.event.pojo.TMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMsgMapper {
    int countByExample(TMsgExample example);

    int deleteByExample(TMsgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMsg record);

    int insertSelective(TMsg record);

    List<TMsg> selectByExample(TMsgExample example);

    TMsg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMsg record, @Param("example") TMsgExample example);

    int updateByExample(@Param("record") TMsg record, @Param("example") TMsgExample example);

    int updateByPrimaryKeySelective(TMsg record);

    int updateByPrimaryKey(TMsg record);
}