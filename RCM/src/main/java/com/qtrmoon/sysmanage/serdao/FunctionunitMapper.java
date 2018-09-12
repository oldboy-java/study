package com.qtrmoon.sysmanage.serdao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.qtrmoon.sysmanage.pojo.Functionunit;

@Component
public interface FunctionunitMapper {
	public List<Functionunit> schFunctionunit(Functionunit functionunit);
	public Functionunit schFunctionunitById(Integer id);
	public Integer addFunctionunit(Functionunit functionunit);
	public void updFunctionunit(Functionunit functionunit);
	public void delFunctionunit(Integer id);
	public void delFunctionunits(Integer[] ids);
	public List<Functionunit> query(String sql);
}
