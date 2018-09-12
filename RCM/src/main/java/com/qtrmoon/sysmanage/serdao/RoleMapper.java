package com.qtrmoon.sysmanage.serdao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.qtrmoon.sysmanage.pojo.Role;

@Component
public interface RoleMapper {
	public List<Role> schRole(Role role);
	public Role schRoleById(Integer id);
	public Integer addRole(Role role);
	public void updRole(Role role);
	public void delRole(Integer id);
	public void delRoles(Integer[] ids);
	public List<Role> query(String sql);
}
