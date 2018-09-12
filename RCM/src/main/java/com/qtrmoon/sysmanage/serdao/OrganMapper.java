package com.qtrmoon.sysmanage.serdao;

import java.util.List;
import org.springframework.stereotype.Component;

import com.qtrmoon.sysmanage.pojo.Organ;

@Component
public interface OrganMapper {
	public List<Organ> schOrgan(Organ organ);
	public Organ schOrganById(Integer id);
	public Integer addOrgan(Organ organ);
	public void updOrgan(Organ organ);
	public void delOrgan(Integer id);
	public void delOrgans(Integer[] ids);
	public List<Organ> query(String sql);
}
