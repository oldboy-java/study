package com.qtrmoon.zygl.serdao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Zyplhf;
/** 资源评论回复表实体映射 */
@Component
public interface ZyplhfMapper {
	/**
	 * Zyplhf的条件查询方法
	 * @param zyplhf 承载查询条件
	 * @return 返回Zyplhf的集合
	 */
	public List<Zyplhf> schZyplhf(Zyplhf zyplhf);
	
	/**
	 * Zyplhf的主键查询方法
	 * @param id 主键值
	 * @return 返回Zyplhf实体
	 */
	public Zyplhf schZyplhfById(Integer id);
	
	/**
	 * Zyplhf的添加方法
	 * @param zyplhf 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZyplhf(Zyplhf zyplhf);
	
	/**
	 * Zyplhf的修改方法
	 * @param zyplhf 承载数据的Bean
	 */
	public void updZyplhf(Zyplhf zyplhf);
	
	/**
	 * Zyplhf的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZyplhf(Integer id);
	
	/**
	 * Zyplhf的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZyplhfs(Integer[] ids);
}
