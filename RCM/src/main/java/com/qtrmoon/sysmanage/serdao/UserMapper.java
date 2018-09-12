package com.qtrmoon.sysmanage.serdao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.qtrmoon.sysmanage.pojo.User;

@Component
public interface UserMapper {
	public List<User> schUser(User user);
	public User schUserById(Integer id);
	public Integer addUser(User user);
	public void updUser(User user);
	public void delUser(Integer id);
	public void delUsers(Integer[] ids);
	public List<User> query(String sql);
	public void updPassword(User user);
}
