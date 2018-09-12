package com.qtrmoon.zygl.serdao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Tzgg;
/** 通知公告表实体映射 */
@Component
public interface TzggMapper {
	/**
	 * Tzgg的条件查询方法
	 * @param tzgg 承载查询条件
	 * @return 返回Tzgg的集合
	 */
	public List<Tzgg> schTzgg(Tzgg tzgg);
	
	/**
	 * Tzgg的最新通知公告查询方法
	 * @return 返回Tzgg的集合
	 */
	public List<Tzgg> schNewTzgg();
	
	/**
	 * Tzgg的主键查询方法
	 * @param id 主键值
	 * @return 返回Tzgg实体
	 */
	public Tzgg schTzggById(Integer id);
	
	/**
	 * Tzgg的添加方法
	 * @param tzgg 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addTzgg(Tzgg tzgg);
	
	/**
	 * Tzgg后台的添加方法
	 * @param tzgg 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addBackTzgg(Tzgg tzgg);
	
	/**
	 * Tzgg的修改方法
	 * @param tzgg 承载数据的Bean
	 */
	public void updTzgg(Tzgg tzgg);
	
	/**
	 * Tzgg的后台修改方法
	 * @param tzgg 承载数据的Bean
	 */
	public void updBackTzgg(Tzgg tzgg);
	
	/**
	 * Tzgg的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delTzgg(Integer id);
	
	/**
	 * Tzgg的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delTzggs(Integer[] ids);
}
