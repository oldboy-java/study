package com.qtrmoon.zygl.serdao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Wjzh;
/** 文件转换表实体映射 */
@Component
public interface WjzhMapper {
	/**
	 * Wjzh的条件查询方法
	 * @param wjzh 承载查询条件
	 * @return 返回Wjzh的集合
	 */
	public List<Wjzh> schWjzh(Wjzh wjzh);
	
	/**
	 * Wjzh的主键查询方法
	 * @param id 主键值
	 * @return 返回Wjzh实体
	 */
	public Wjzh schWjzhById(Integer id);
	
	/**
	 * Wjzh的添加方法
	 * @param wjzh 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addWjzh(Wjzh wjzh);
	
	/**
	 * Wjzh的修改方法
	 * @param wjzh 承载数据的Bean
	 */
	public void updWjzh(Wjzh wjzh);
	
	/**
	 * Wjzh的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delWjzh(Integer id);
	
	/**
	 * Wjzh的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delWjzhs(Integer[] ids);

	/**
	 * 批量更新是否发布
	 * @param ids
	 */
	public void updWjzhSftb(List<Integer> ids);
}
