package com.qtrmoon.sysmanage.serdao;
import java.util.List;
import java.util.Map;

import com.qtrmoon.sysmanage.pojo.*;
public interface ISysmanageService {
	/**
	 * Function的条件查询方法
	 * @param function 承载查询条件
	 * @return 返回Function的集合
	 */
	public List<Function> schFunction(Function function);
	/**
	 * Function的主键查询方法
	 * @param id 主键值
	 * @return 返回Function实体
	 */
	public Function schFunctionById(Integer id);
	/**
	 * Function的添加方法
	 * @param function 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addFunction(Function function);
	/**
	 * Function的修改方法
	 * @param function 承载数据的Bean
	 */
	public void updFunction(Function function);
	/**
	 * Function的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delFunction(Integer id);
	/**
	 * Function的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delFunction(Integer[] ids);

	public List<Functionunit> schFunctionunit(Functionunit functionunit);
	public Functionunit schFunctionunitById(Integer id);
	public Integer addFunctionunit(Functionunit functionunit);
	public void updFunctionunit(Functionunit functionunit);
	public void delFunctionunit(Integer id);
	public void delFunctionunit(Integer[] ids);

	public List<Organ> schOrgan(Organ organ);
	public Organ schOrganById(Integer id);
	public Integer addOrgan(Organ organ);
	public void updOrgan(Organ organ);
	public void delOrgan(Integer id);
	public void delOrgan(Integer[] ids);

	public List<Role> schRole(Role role);
	public Role schRoleById(Integer id);
	public Integer addRole(Role role);
	public void updRole(Role role);
	public void delRole(Integer id);
	public void delRole(Integer[] ids);

	public List<User> schUser(User user);
	public User schUserById(Integer id);
	public Integer addUser(User user);
	public void updUser(User user);
	public void delUser(Integer id);
	public void delUser(Integer[] ids);
	public void updPassword(User user);
	
	/**
	 * 为用户分配权限集合
	 * @param loginUser
	 * @return
	 */
	public Function setUserAuthor(User loginUser);
	
	/***************** Module方法组 *****************/
	/**
	 * Module的条件查询方法
	 * @param module 承载查询条件的Bean
	 * @return 返回Module的集合
	 */
	public List<Module> schModule(Module module);
	
	/**
	 * Module的主键查询方法
	 * @param id 主键值
	 * @return 返回Module实体
	 */
	public Module schModuleById(Integer id);
	
	/**
	 * Module的添加方法
	 * @param module 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addModule(Module module);
	
	/**
	 * Module的修改方法
	 * @param module 承载数据的Bean
	 */
	public void updModule(Module module);
	
	/**
	 * Module的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delModule(Integer id);
	
	/**
	 * Module的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delModule(Integer[] ids);

}
