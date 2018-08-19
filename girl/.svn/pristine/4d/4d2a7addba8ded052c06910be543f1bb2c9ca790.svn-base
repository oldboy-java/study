package com.imooc.girl.service;

import java.util.List;


import com.imooc.girl.pojo.Girl;

public interface GirlService {
	
	/***
	 * 查询所有女生
	 * @return
	 */
	public List<Girl> girlList();
	
	
	/**
	 * 添加女生
	 * @param girl
	 * @return
	 */
	public Girl addGirl(Girl girl) throws Exception;
	
	
	/***
	 * 更新女生
	 * @param girl
	 * @return
	 */
	public Girl updateGirl(Girl girl);
	
	
	/***
	 * 根据主键查询单个女生
	 * @param id
	 * @return
	 */
	public Girl findGirl(Integer id);
	
	/***
	 * 删除女生
	 * @param id
	 */
	public void deleteGirl(Integer id);
	
	/***
	 * 根据年龄查询女生
	 * @param age
	 * @return
	 */
	public List<Girl> girlListByAge(Integer age);
	
	/**
	 * 查询女生年龄
	 * @param id
	 * @return
	 */
	public Integer getGirlAge(Integer id) throws Exception;
}
