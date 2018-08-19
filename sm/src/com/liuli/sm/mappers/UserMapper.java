package com.liuli.sm.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.liuli.sm.pojo.User;
import com.liuli.sm.vo.UserQueryVo;

/***
 * Xml对应的mapper映射器必须与 namespace中路径相同
 * @author Administrator
 */

@Repository
public interface UserMapper {

	/**
	 * 添加用户
	 * @param user
	 * @return 返回影响的行数,只需要定义好返回值，mybatis自动处理
	 */
	public int addUser(User user);
	
	
	/**
	 * 批量添加： 采用集合传参
	 * @param user
	 * @return
	 */
	public int batchAddUser(List<User> user);
	
	/**
	 * 批量添加：数组传参
	 * @param user
	 * @return
	 */
	public int batchAddUser2(User[]user);
	
	
	/**
	 * 删除用户
	 * @param userId
	 * @return 返回影响的行数,只需要定义好返回值，mybatis自动处理
	 */
	public int deleteUserById(int userId);
	
	/**
	 * 更新用户
	 * @param user
	 * @return 返回影响的行数,只需要定义好返回值，mybatis自动处理
	 */
	public int updateUser(User user);
	
	/**
	 * 查询单个用户
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId);
	
	/**
	 * 查询单个用户
	 * @param userId
	 * @return
	 */
	public Map<String,Object> getUser2ById(int userId);
	
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> getAllUsers2();
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Map<String,Object>> getAllUsers3();
	
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> getUserByPage(UserQueryVo vo);
	
	
	/**
	 * 查询所有用户数
	 * @return
	 */
	public int getAllUserCount();
	
	
	/**
	 * 根据姓名查询所有用户数 (like)
	 * @return
	 */
	public int getAllUserCountByName(String name);
	
	/**
	 * 根据姓名和年龄查询（多条件查询）
	 * @param name
	 * @param age
	 * @return
	 */
	public User getUserByNameAge(@Param("name2")String name ,@Param("age2")int age);
	
	
	/**
	 * 根据姓名和年龄查询（使用map封装多个查询条件）
	 * @return
	 */
	public User getUserByNameAge2(Map<String,Object> map);
	
}
