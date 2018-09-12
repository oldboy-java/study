package com.qtrmoon.sysmanage.serdao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.qtrmoon.sysmanage.pojo.Module;

@Component
public interface ModuleMapper {
	/**
	 * Module的条件查询方法
	 * @param module 承载查询条件
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
	public void delModules(Integer[] ids);
}
