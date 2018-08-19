package com.liuli.sm.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.liuli.sm.mappers.UserMapper;
import com.liuli.sm.pojo.User;
import com.liuli.sm.service.UserService;
import com.liuli.sm.vo.UserQueryVo;


/***
 * @author Administrator
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class UserTest {

	@Autowired
	private UserMapper userMapper ;
	
	@Autowired
	private UserService userService;
	
	/*@Test
	public void testAddUser() {
		User user = new User(-1,"�ɿ��",32);
		int insert = userMapper.addUser(user);
		System.err.println(insert+",userId="+user.getUserId());
	}
	
	@Test
	public void testAddUser2() {
		User user = new User(-1,"�ɿ��2",32);
		int insert = userService.addUser(user);
		System.err.println(insert+",userId="+user.getUserId());
	}
	
	@Test
	public void testBatchAddUser() {
		long start = System.currentTimeMillis();
		int size = 10000;
		
		List<User> userList = new LinkedList<User>();
		for(int i = 0; i <size;i++){
			userList.add(new User(-1,"������"+i,32+i));
		}
		int insert = userMapper.batchAddUser(userList);	
		long end = System.currentTimeMillis();
		System.err.println("�ܺ�ʱ:"+(end-start)+"����");
	}
	
	
	@Test
	public void testDeleteUser() {
		int delete = userMapper.deleteUserById(24521);
		System.err.println(delete);
	}
	
	
	

	@Test
	public void tesUpdateUser() {
		User user = new User(24523,"�ɿ��",52);
		int update = userMapper.updateUser(user);
		System.err.println(update);
	}
*/
	
	@Test
	public void testGetUser() {
		User user = userMapper.getUserById(24523);
		System.err.println(user.toString());
	}
	
	@Test
	public void testGetUser2() {
		Map<String,Object> user = userMapper.getUser2ById(24523);
		System.err.println(user.toString());
	}
	
	@Test
	public void testGetAllUsers() {
		List<User> userList = userMapper.getAllUsers();
		System.err.println(userList.toString());
	}
	
	
	@Test
	public void testGetUserByPage() {
		UserQueryVo vo  = new UserQueryVo();
		vo.getPage().setNowPage(2);
		vo.getPage().setPageShow(2);
		List<User> userList = userMapper.getUserByPage(vo);
		System.err.println(userList.toString());
	}
	
	
	/*@Test
	public void testGetAllUserCount() {
		int count = userMapper.getAllUserCount();
		System.err.println("�ܼ�¼��-->>>"+count);
	}
	
	
	@Test
	public void testGetUserByNameAge() {
		User user = userMapper.getUserByNameAge("�ɿ��",32);
		System.err.println(user.toString());
	}
	
	
	@Test
	public void testGetAllUserCountByName() {
		int count = userMapper.getAllUserCountByName("�ɿ��");
		System.err.println("�ܼ�¼��-->>>"+count);
	}*/
}
