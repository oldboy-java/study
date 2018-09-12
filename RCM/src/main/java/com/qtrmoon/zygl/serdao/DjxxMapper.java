package com.qtrmoon.zygl.serdao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Djxx;
/** 等级信息实体映射 */
@Component
public interface DjxxMapper {
	/**
	 * Djxx的条件查询方法
	 * @param djxx 承载查询条件
	 * @return 返回Djxx的集合
	 */
	public List<Djxx> schDjxx(Djxx djxx);
	
	/**
	 * Djxx的主键查询方法
	 * @param id 主键值
	 * @return 返回Djxx实体
	 */
	public Djxx schDjxxById(Integer id);
	
	/**
	 * Djxx的添加方法
	 * @param djxx 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addDjxx(Djxx djxx);
	
	/**
	 * Djxx的修改方法
	 * @param djxx 承载数据的Bean
	 */
	public void updDjxx(Djxx djxx);
	
	/**
	 * Djxx的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delDjxx(Integer id);
	
	/**
	 * Djxx的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delDjxxs(Integer[] ids);

	/***
	 * 根据等级名称查询等级信息
	 * @param djmc 等级名称
	 * @return
	 */
	public Djxx schDjxxByDjmc(String djmc);

	/***
	 * 按积分查询等级信息
	 * @param jf 积分
	 * @return
	 */
	public Djxx schDjxxByJf(Integer jf);
}
