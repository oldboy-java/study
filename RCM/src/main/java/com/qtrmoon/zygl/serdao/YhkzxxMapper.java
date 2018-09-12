package com.qtrmoon.zygl.serdao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Yhkzxx;
/** 用户扩展信息实体映射 */
@Component
public interface YhkzxxMapper {
	/**
	 * Yhkzxx的条件查询方法
	 * @param yhkzxx 承载查询条件
	 * @return 返回Yhkzxx的集合
	 */
	public List<Yhkzxx> schYhkzxx(Yhkzxx yhkzxx);
	
	/**
	 * Yhkzxx的主键查询方法
	 * @param id 主键值
	 * @return 返回Yhkzxx实体
	 */
	public Yhkzxx schYhkzxxById(Integer id);
	
	/**
	 * Yhkzxx的添加方法
	 * @param yhkzxx 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addYhkzxx(Yhkzxx yhkzxx);
	
	/**
	 * Yhkzxx的修改方法
	 * @param yhkzxx 承载数据的Bean
	 */
	public void updYhkzxx(Yhkzxx yhkzxx);
	
	/**
	 * Yhkzxx的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delYhkzxx(Integer id);
	
	/**
	 * Yhkzxx的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delYhkzxxs(Integer[] ids);
}
