package com.qtrmoon.zygl.serdao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Zyll;
/** 资源浏览表实体映射 */
@Component
public interface ZyllMapper {
	/**
	 * Zyll的条件查询方法
	 * @param zyll 承载查询条件
	 * @return 返回Zyll的集合
	 */
	public List<Zyll> schZyll(Zyll zyll);
	
	/**
	 * Zyll的查询浏览的资源以及浏览信息
	 * @param zyll 承载查询条件
	 * @return 返回Zyll的集合
	 */
	public List<Zyll> schZyAndZyll(Zyll zyll);
	
	/**
	 * Zyll的主键查询方法
	 * @param id 主键值
	 * @return 返回Zyll实体
	 */
	public Zyll schZyllById(Integer id);
	
	/**
	 * Zyll的添加方法
	 * @param zyll 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZyll(Zyll zyll);
	
	/**
	 * Zyll的修改方法
	 * @param zyll 承载数据的Bean
	 */
	public void updZyll(Zyll zyll);
	
	/**
	 * Zyll的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZyll(Integer id);
	
	/**
	 * Zyll的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZylls(Integer[] ids);
	
	/**
	 * Zyll的浏览量方法
	 * @param zyid资源id
	 */
	public Integer schZyllCount(@Param("zyid")String zyid);
}
