package com.qtrmoon.sysmanage.serdao;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtrmoon.sysmanage.pojo.*;

@Service("sysmanageService")
public class SysmanageServiceImpl implements ISysmanageService {
	@Autowired
	private FunctionMapper functionMapper;

	@Autowired
	private FunctionunitMapper functionunitMapper;

	@Autowired
	private OrganMapper organMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ModuleMapper moduleMapper;


	@Override
	public List<Function> schFunction(Function function) {
		if(function.getPagesize()>0){
			PageHelper.startPage(function.getPage(), function.getPagesize());
		}
		List<Function> list=functionMapper.schFunction(function);
		if(function.getPagesize()>0){
			Page<Function> page = (Page<Function>)list;
			function.setDatasize(page.getTotal());
		}
		return list;
	}
	
	@Override
	public Function schFunctionById(Integer id) {
		return functionMapper.schFunctionById(id);
	}
	
	@Override
	public Integer addFunction(Function function) {
		return functionMapper.addFunction(function);
	}

	@Override
	public void updFunction(Function function) {
		functionMapper.updFunction(function);
	}

	@Override
	public void delFunction(Integer id) {
		functionMapper.delFunction(id);
	}

	@Override
	public void delFunction(Integer[] ids) {
		functionMapper.delFunctions(ids);
	}


	@Override
	public List<Functionunit> schFunctionunit(Functionunit functionunit) {
		PageHelper.startPage(functionunit.getPage(), functionunit.getPagesize());
		List<Functionunit> list=functionunitMapper.schFunctionunit(functionunit);
		Page<Functionunit> page = (Page<Functionunit>)list;
		functionunit.setDatasize(page.getTotal());
		return list;
	}
	
	@Override
	public Functionunit schFunctionunitById(Integer id) {
		return functionunitMapper.schFunctionunitById(id);
	}
	
	@Override
	public Integer addFunctionunit(Functionunit functionunit) {
		return functionunitMapper.addFunctionunit(functionunit);
	}

	@Override
	public void updFunctionunit(Functionunit functionunit) {
		functionunitMapper.updFunctionunit(functionunit);
	}

	@Override
	public void delFunctionunit(Integer id) {
		functionunitMapper.delFunctionunit(id);
	}

	@Override
	public void delFunctionunit(Integer[] ids) {
		functionunitMapper.delFunctionunits(ids);
	}


	@Override
	public List<Organ> schOrgan(Organ organ) {
		PageHelper.startPage(organ.getPage(), organ.getPagesize());
		List<Organ> list=organMapper.schOrgan(organ);
		Page<Organ> page = (Page<Organ>)list;
		organ.setDatasize(page.getTotal());
		return list;
	}
	
	@Override
	public Organ schOrganById(Integer id) {
		return organMapper.schOrganById(id);
	}
	
	@Override
	public Integer addOrgan(Organ organ) {
		return organMapper.addOrgan(organ);
	}

	@Override
	public void updOrgan(Organ organ) {
		organMapper.updOrgan(organ);
	}

	@Override
	public void delOrgan(Integer id) {
		organMapper.delOrgan(id);
	}

	@Override
	public void delOrgan(Integer[] ids) {
		organMapper.delOrgans(ids);
	}


	@Override
	public List<Role> schRole(Role role) {
		if(role.getPagesize()>0){
			PageHelper.startPage(role.getPage(), role.getPagesize());
		}
		List<Role> list=roleMapper.schRole(role);
		if(role.getPagesize()>0){
			Page<Role> page = (Page<Role>)list;
			role.setDatasize(page.getTotal());
		}else{
			role.setDatasize(list.size());
		}
		return list;
	}
	
	@Override
	public Role schRoleById(Integer id) {
		return roleMapper.schRoleById(id);
	}
	
	@Override
	public Integer addRole(Role role) {
		AuthorCache.ins().clear();
		return roleMapper.addRole(role);
	}

	@Override
	public void updRole(Role role) {
		AuthorCache.ins().clear();
		roleMapper.updRole(role);
	}

	@Override
	public void delRole(Integer id) {
		roleMapper.delRole(id);
	}

	@Override
	public void delRole(Integer[] ids) {
		roleMapper.delRoles(ids);
	}


	@Override
	public List<User> schUser(User user) {
		PageHelper.startPage(user.getPage(), user.getPagesize());
		List<User> list=userMapper.schUser(user);
		Page<User> page = (Page<User>)list;
		user.setDatasize(page.getTotal());
		return list;
	}
	
	@Override
	public User schUserById(Integer id) {
		return userMapper.schUserById(id);
	}
	
	@Override
	public Integer addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public void updUser(User user) {
		userMapper.updUser(user);
	}

	@Override
	public void delUser(Integer id) {
		userMapper.delUser(id);
	}

	@Override
	public void delUser(Integer[] ids) {
		userMapper.delUsers(ids);
	}


	@Override
	public void updPassword(User user) {
		userMapper.updPassword(user);
	}
	/***************** Module方法组 *****************/
	/**
	 * Module的条件查询方法
	 * @param module 承载查询条件的Bean
	 * @return 返回Module的集合
	 */
	@Override
	public List<Module> schModule(Module module) {
		if(module.getPagesize()>0){
			PageHelper.startPage(module.getPage(), module.getPagesize());
		}
		List<Module> list=moduleMapper.schModule(module);
		if(module.getPagesize()>0){
			Page<Module> page = (Page<Module>)list;
			module.setDatasize(page.getTotal());
		}else{
			module.setDatasize(list.size());
		}
		return list;
	}
	
	/**
	 * Module的主键查询方法
	 * @param id 主键值
	 * @return 返回Module实体
	 */
	@Override
	public Module schModuleById(Integer id) {
		return moduleMapper.schModuleById(id);
	}
	
	/**
	 * Module的添加方法
	 * @param module 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addModule(Module module) {
		return moduleMapper.addModule(module);
	}

	/**
	 * Module的修改方法
	 * @param module 承载数据的Bean
	 */
	@Override
	public void updModule(Module module) {
		moduleMapper.updModule(module);
	}

	/**
	 * Module的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delModule(Integer id) {
		moduleMapper.delModule(id);
	}

	/**
	 * Module的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delModule(Integer[] ids) {
		moduleMapper.delModules(ids);
	}
	
	@Override
	public Function setUserAuthor(User loginUser) {
		AuthorCache auth = AuthorCache.ins();
		if(auth.empty()){
			Role r=new Role();
			r.setPagesize(-1);
			
			Function f=new Function();
			f.setPagesize(-1);
			
			Module m=new Module();
			m.setPagesize(-1);
			
			auth.init(schModule(m),schRole(r), schFunction(f));
		}
		return AuthorCache.ins().setUserAuthor(loginUser);
	}


}
