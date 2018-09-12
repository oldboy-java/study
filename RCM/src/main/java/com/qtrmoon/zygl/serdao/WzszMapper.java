package com.qtrmoon.zygl.serdao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Wzsz;
/** 网站设置实体映射 */
@Component
public interface WzszMapper {
	/**
	 * Wzsz的条件查询方法
	 * @param wzsz 承载查询条件
	 * @return 返回Wzsz的集合
	 */
	public List<Wzsz> schWzsz(Wzsz wzsz);
	
	/**
	 * Wzsz的主键查询方法
	 * @param id 主键值
	 * @return 返回Wzsz实体
	 */
	public Wzsz schWzszById(Integer id);
	
	/**
	 * Wzsz的添加方法
	 * @param wzsz 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addWzsz(Wzsz wzsz);
	
	/**
	 * Wzsz的修改方法
	 * @param wzsz 承载数据的Bean
	 */
	public void updWzsz(Wzsz wzsz);	

}
