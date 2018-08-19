package com.liuli.event.mapper;

import com.liuli.event.pojo.TFlight;
import com.liuli.event.pojo.TFlightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFlightMapper {
    int countByExample(TFlightExample example);

    int deleteByExample(TFlightExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TFlight record);

    int insertSelective(TFlight record);

    List<TFlight> selectByExample(TFlightExample example);

    TFlight selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TFlight record, @Param("example") TFlightExample example);

    int updateByExample(@Param("record") TFlight record, @Param("example") TFlightExample example);

    int updateByPrimaryKeySelective(TFlight record);

    int updateByPrimaryKey(TFlight record);
}