package com.qtrmoon.zygl.serdao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Zysc;
/** 资源收藏表实体映射 */
@Component
public interface ZyscMapper {
	/**
	 * Zysc的条件查询方法
	 * @param zysc 承载查询条件
	 * @return 返回Zysc的集合
	 */
	public List<Zysc> schZysc(Zysc zysc);
	
	/**
	 * Zysc的资源和收藏信息查询方法
	 * @param zysc 承载查询条件
	 * @return 返回Zysc的集合
	 */
	public List<Zysc> schZyAndZysc(Zysc zysc);
	
	/**
	 * Zysc的主键查询方法
	 * @param id 主键值
	 * @return 返回Zysc实体
	 */
	public Zysc schZyscById(Integer id);
	
	/**
	 * Zysc的添加方法
	 * @param zysc 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZysc(Zysc zysc);
	
	/**
	 * Zysc的修改方法
	 * @param zysc 承载数据的Bean
	 */
	public void updZysc(Zysc zysc);
	
	/**
	 * Zysc的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZysc(Integer id);
	
	/**
	 * Zysc的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZyscs(Integer[] ids);
	
	/**
	 * Zysc的收藏量方法
	 * @param zyid资源id
	 */
	public Integer schZyscCount(@Param("zyid")String zyid);

	/***
	 * 删除收藏
	 * @param userId
	 * @param zyId
	 */
	public void delZyscByUserIdZyId(Map map);
}
