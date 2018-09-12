package com.qtrmoon.sysmanage.serdao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtrmoon.sysmanage.SysConstant;
import com.qtrmoon.sysmanage.pojo.Function;
import com.qtrmoon.sysmanage.pojo.Module;
import com.qtrmoon.sysmanage.pojo.Role;
import com.qtrmoon.sysmanage.pojo.User;
import com.qtrmoon.toolkit.tree.TreeNode;
import com.qtrmoon.toolkit.tree.TreeUtil;

public class AuthorCache {
	private static AuthorCache aUtil;
	private static List<Module> moduleList;
	private static List<Role> roleList;
	private static List<Function>funcList;
	
	private AuthorCache(){}
	
	public static AuthorCache ins(){
		if(aUtil==null){
			aUtil=new AuthorCache();
		}
		return aUtil;
	}
	
	/**
	 * 获取用户的合法权限集合，构造专属菜单。
	 * @param id
	 * @return
	 */
	public Function setUserAuthor(User user) {
		String roles=user.getRoles();//获取用户角色并格式化。
		if(roles==null)return null;
		roles=","+roles.trim().replaceAll(" ", "")+",";
		String funcstr="";//获取用户功能集主键串
		for(Role role:roleList){
			if(roles.indexOf(","+role.getId()+",")>=0){
				funcstr+=role.getFuncs()+",";
			}
		}
		if(funcstr.length()>0){//功能集主键串格式化
			funcstr=funcstr.substring(0,funcstr.length()-1);
			funcstr=","+funcstr.trim().replaceAll(" ", "")+",";
		}
		List<Function> flist=new ArrayList<Function>();//用户功能权限集合
		for(Function fun:funcList){
			if(funcstr.indexOf(","+fun.getId()+",")>=0&&!flist.contains(fun)){
				flist.add(fun);
			}
		}
		//用户构造带根节点的功能权限集合，从缓存中重新clone，重组树结构。
		List<Function> newflist=new ArrayList<Function>();
		for(Function fun:flist){
			trace(fun,newflist);
		}
		List<Function> menuList=new ArrayList<Function>();//用户菜单集合，构造菜单树
		for (Function fun:newflist){
			if (fun.getIsshow().equals(SysConstant.FUNCTION_SHOW)) {
				menuList.add(fun);
			}
		}
		new FunctionTreeUtil().getOrderTree(menuList);
		TreeNode root=(new FunctionTreeUtil()).getTreeRoot(menuList);
		
		user.setMenu(newflist);
		return (Function)root;
	}
	
	private void trace(Function fun, List<Function> newflist) {
		if(fun==null)return;
		if(!hasAdd(fun.getId(),newflist)){
			newflist.add(fun.clone());
		}
		trace((Function)fun.getPNode(),newflist);	
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	private boolean hasAdd(Integer id,List<Function> newflist) {
		for(Function fun:newflist){
			if(fun.getId().intValue()==id){
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取用户持有的模块。
	 * @param user
	 * @return
	 */
	public List<Module> getUserModule(User user){
		List<Module> nlist=new ArrayList<Module>();
		List<Function> flist=user.getMenu();
		for(Module m:moduleList){
			for(Function f:flist){
				if(m.getFuncIndex().indexOf(","+f.getId()+",")>=0){
					nlist.add(m);
					break;
				}
			}
		}
		return nlist;
	}
	
	/**
	 * 获取模块下的主菜单
	 * @param id 模块id
	 * @param user 当前登录用户
	 * @return
	 */
	public List<Function> schMenuByModule(int id, User user) {
		String funcIndex="";
		for(Module m:moduleList){
			if(id==m.getId()){
				funcIndex=m.getFuncIndex();
			}
		}
		List<Function> menuList=user.getMenu();
		List<Function> flist=new ArrayList<Function>();
		for(Function fun:menuList){
			if(funcIndex.indexOf(","+fun.getId()+",")>=0){
				flist.add(fun);
			}
		}
		return flist;
	}
	/**
	 * 初始化权限缓存集合
	 * @param mList 模块集合
	 * @param rlist 角色集合
	 * @param flist 功能集合
	 */
	public void init(List<Module> mList,List<Role> rlist,List<Function>flist){
		if(mList!=null){
			moduleList=mList;
			for(Module m:moduleList){
				String funcs=m.getFuncs();
				funcs=funcs.trim();
				funcs=","+funcs+",";
				m.setFuncIndex(funcs);
			}
		}
		if(rlist!=null)roleList=rlist;
		if(flist!=null){
			funcList=flist;
			new FunctionTreeUtil().getOrderTree(funcList);
		}
	}

	/**
	 * 是否需要调用init初始化权限缓存集合
	 * @return
	 */
	public boolean empty() {
		return roleList==null||funcList==null;
	}
	
	/**
	 * 清空权限缓存
	 * 添加和修改角色时调用了此方法。
	 */
	public void clear(){
		roleList=null;
		funcList=null;
		moduleList=null;
	}

}

class FunctionTreeUtil extends TreeUtil{
	@Override
	public String render(TreeNode node) {
		return null;
	}
}