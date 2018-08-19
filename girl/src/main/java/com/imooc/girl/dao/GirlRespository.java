package com.imooc.girl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.girl.pojo.Girl;

public interface GirlRespository extends JpaRepository<Girl, Integer> {
	
	/***
	 * 根据年龄查询：方法名固定findByAge
	 * @param age
	 * @return
	 */
	public List<Girl> findByAge(Integer age);

}
