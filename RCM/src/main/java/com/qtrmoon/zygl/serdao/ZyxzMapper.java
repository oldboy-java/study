package com.qtrmoon.zygl.serdao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.pojo.Zyxz;
/** 资源下载表实体映射 */
@Component
public interface ZyxzMapper {
	/**
	 * Zyxz的条件查询方法
	 * @param zyxz 承载查询条件
	 * @return 返回Zyxz的集合
	 */
	public List<Zyxz> schZyxz(Zyxz zyxz);  
	
	/**
	 * Zyxz的当前用户下载信息和资源信息
	 * @param zyxz 承载查询条件
	 * @return 返回Zyxz的集合
	 */
	public List<Zyxz> schMyZyxz(Zyxz zyxz);
	
	/**
	 * Zyxz的当前用户的资源信息和被下载信息
	 * @param zyxz 承载查询条件
	 * @return 返回Zyxz的集合
	 */
	public List<Zyxz> schMyZyAndZyxz(Zyxz zyxz);
	
	/**
	 * Zyxz的主键查询方法
	 * @param id 主键值
	 * @return 返回Zyxz实体
	 */
	public Zyxz schZyxzById(Integer id);
	
	/**
	 * Zyxz的添加方法
	 * @param zyxz 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZyxz(Zyxz zyxz);
	
	/**
	 * Zyxz的修改方法
	 * @param zyxz 承载数据的Bean
	 */
	public void updZyxz(Zyxz zyxz);
	
	/**
	 * Zyxz的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZyxz(Integer id);
	
	/**
	 * Zyxz的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZyxzs(Integer[] ids);
	
	/**
	 * Zyxz的下载量方法
	 * @param zyid资源id
	 */
	public Integer schZyxzCount(@Param("zyid")String zyid);
	
	/**
	 * 统计资源下载
	 */
	public List<Map<String,Object>> schZyxzcs(@Param("zy") Zy zy);
}
