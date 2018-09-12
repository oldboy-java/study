package com.qtrmoon.zygl.serdao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Xklb;
/** 学科类别表实体映射 */
@Component
public interface XklbMapper {
	/**
	 * Xklb的条件查询方法
	 * @param xklb 承载查询条件
	 * @return 返回Xklb的集合
	 */
	public List<Xklb> schXklb(Xklb xklb);
	
	/**
	 * Xklb的主键查询方法
	 * @param id 主键值
	 * @return 返回Xklb实体
	 */
	public Xklb schXklbById(Integer id);
	
	/**
	 * Xklb的添加方法
	 * @param xklb 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addXklb(Xklb xklb);
	
	/**
	 * Xklb的修改方法
	 * @param xklb 承载数据的Bean
	 */
	public void updXklb(Xklb xklb);
	
	/**
	 * Xklb的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delXklb(Integer id);
	
	/**
	 * Xklb的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delXklbs(Integer[] ids);
}
