package com.liuli.sm.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.liuli.sm.pojo.User;
import com.liuli.sm.vo.UserQueryVo;

/***
 * Xml��Ӧ��mapperӳ���������� namespace��·����ͬ
 * @author Administrator
 */

@Repository
public interface UserMapper {

	/**
	 * ����û�
	 * @param user
	 * @return ����Ӱ�������,ֻ��Ҫ����÷���ֵ��mybatis�Զ�����
	 */
	public int addUser(User user);
	
	
	/**
	 * ������ӣ� ���ü��ϴ���
	 * @param user
	 * @return
	 */
	public int batchAddUser(List<User> user);
	
	/**
	 * ������ӣ����鴫��
	 * @param user
	 * @return
	 */
	public int batchAddUser2(User[]user);
	
	
	/**
	 * ɾ���û�
	 * @param userId
	 * @return ����Ӱ�������,ֻ��Ҫ����÷���ֵ��mybatis�Զ�����
	 */
	public int deleteUserById(int userId);
	
	/**
	 * �����û�
	 * @param user
	 * @return ����Ӱ�������,ֻ��Ҫ����÷���ֵ��mybatis�Զ�����
	 */
	public int updateUser(User user);
	
	/**
	 * ��ѯ�����û�
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId);
	
	/**
	 * ��ѯ�����û�
	 * @param userId
	 * @return
	 */
	public Map<String,Object> getUser2ById(int userId);
	
	
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public List<User> getAllUsers2();
	
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public List<Map<String,Object>> getAllUsers3();
	
	
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public List<User> getUserByPage(UserQueryVo vo);
	
	
	/**
	 * ��ѯ�����û���
	 * @return
	 */
	public int getAllUserCount();
	
	
	/**
	 * ����������ѯ�����û��� (like)
	 * @return
	 */
	public int getAllUserCountByName(String name);
	
	/**
	 * ���������������ѯ����������ѯ��
	 * @param name
	 * @param age
	 * @return
	 */
	public User getUserByNameAge(@Param("name2")String name ,@Param("age2")int age);
	
	
	/**
	 * ���������������ѯ��ʹ��map��װ�����ѯ������
	 * @return
	 */
	public User getUserByNameAge2(Map<String,Object> map);
	
}
