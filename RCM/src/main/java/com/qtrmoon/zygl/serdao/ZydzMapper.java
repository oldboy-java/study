package com.qtrmoon.zygl.serdao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Zydz;
/** 资源点赞表实体映射 */
@Component
public interface ZydzMapper {
	/**
	 * Zydz的条件查询方法
	 * @param zydz 承载查询条件
	 * @return 返回Zydz的集合
	 */
	public List<Zydz> schZydz(Zydz zydz);
	
	/**
	 * Zydz的主键查询方法
	 * @param id 主键值
	 * @return 返回Zydz实体
	 */
	public Zydz schZydzById(Integer id);
	
	/**
	 * Zydz的添加方法
	 * @param zydz 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZydz(Zydz zydz);
	
	/**
	 * Zydz的修改方法
	 * @param zydz 承载数据的Bean
	 */
	public void updZydz(Zydz zydz);
	
	/**
	 * Zydz的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZydz(Integer id);
	
	/**
	 * Zydz的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZydzs(Integer[] ids);

	/***
	 * 取消点赞
	 * @param map
	 */
	public void delZydzByUserIdZyId(Map map);
}
