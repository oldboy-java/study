package com.qtrmoon.sysmanage.serdao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.qtrmoon.sysmanage.pojo.Function;

@Component
public interface FunctionMapper {
	/**
	 * Function的条件查询方法
	 * @param function 承载查询条件
	 * @return 返回Function的集合
	 */
	public List<Function> schFunction(Function function);
	
	/**
	 * @param id
	 * @return
	 */
	public Function schFunctionById(Integer id);
	
	/**
	 * @param function
	 * @return
	 */
	public Integer addFunction(Function function);
	
	/**
	 * @param function
	 */
	public void updFunction(Function function);
	
	/**
	 * @param id
	 */
	public void delFunction(Integer id);
	
	/**
	 * @param ids
	 */
	public void delFunctions(Integer[] ids);
}
