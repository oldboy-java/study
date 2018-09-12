package com.qtrmoon.zygl.serdao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.pojo.Zypl;
/** 资源评论表实体映射 */
@Component
public interface ZyplMapper {
	/**
	 * Zypl的条件查询方法
	 * @param zypl 承载查询条件
	 * @return 返回Zypl的集合
	 */
	public List<Zypl> schZypl(Zypl zypl);
	
	/**
	 * Zypl的评论的资源以及评论信息
	 * @param zypl 承载查询条件
	 * @return 返回Zypl的集合
	 */
	public List<Zypl> schZyAndZypl(Zypl zypl);
	
	/**
	 * Zypl的主键查询方法
	 * @param id 主键值
	 * @return 返回Zypl实体
	 */
	public Zypl schZyplById(Integer id);
	
	/**
	 * Zypl的添加方法
	 * @param zypl 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZypl(Zypl zypl);
	
	/**
	 * Zypl的评论回复添加方法
	 * @param zypl 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZyplhf(Zypl zypl);
	
	/**
	 * Zypl的修改方法
	 * @param zypl 承载数据的Bean
	 */
	public void updZypl(Zypl zypl);
	
	/**
	 * Zypl的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZypl(Integer id);
	
	/**
	 * Zypl的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZypls(Integer[] ids);
	
	/**
	 * 统计资源评论
	 */
	public List<Map<String,Object>> schZyplcs(@Param("zy") Zy zy);

}
