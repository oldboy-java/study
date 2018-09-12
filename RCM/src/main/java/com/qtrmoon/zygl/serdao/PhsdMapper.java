package com.qtrmoon.zygl.serdao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Phsd;
/** 偏好设定实体映射 */
@Component
public interface PhsdMapper {
	/**
	 * Phsd的条件查询方法
	 * @param phsd 承载查询条件
	 * @return 返回Phsd的集合
	 */
	public List<Phsd> schPhsd(Phsd phsd);
	
	/**
	 * Phsd的主键查询方法
	 * @param id 主键值
	 * @return 返回Phsd实体
	 */
	public Phsd schPhsdById(Integer id);
	
	/**
	 * Phsd的添加方法
	 * @param phsd 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addPhsd(Phsd phsd);
	
	/**
	 * Phsd的修改方法
	 * @param phsd 承载数据的Bean
	 */
	public void updPhsd(Phsd phsd);
	
	/**
	 * Phsd的根据用户id修改方法
	 * @param phsd 承载数据的Bean
	 */
	public void updPhsdByUser(Phsd phsd);
	
	/**
	 * Phsd的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delPhsd(Integer id);
	
	/**
	 * Phsd的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delPhsds(Integer[] ids);

	/**
	 * 查询用户的偏好设定
	 * @param userId
	 * @return
	 */
	public Phsd schPhsdByUserId(Integer userId);
}
