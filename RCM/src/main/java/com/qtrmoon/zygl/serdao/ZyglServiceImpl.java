package com.qtrmoon.zygl.serdao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qtrmoon.common.PageSizeEnum;
import com.qtrmoon.zygl.pojo.Djxx;
import com.qtrmoon.zygl.pojo.Phsd;
import com.qtrmoon.zygl.pojo.Tzgg;
import com.qtrmoon.zygl.pojo.Wjzh;
import com.qtrmoon.zygl.pojo.Wzsz;
import com.qtrmoon.zygl.pojo.Xklb;
import com.qtrmoon.zygl.pojo.Yhkzxx;
import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.pojo.Zydz;
import com.qtrmoon.zygl.pojo.Zyll;
import com.qtrmoon.zygl.pojo.Zypl;
import com.qtrmoon.zygl.pojo.Zyplhf;
import com.qtrmoon.zygl.pojo.Zysc;
import com.qtrmoon.zygl.pojo.Zyxz;

/** 资源管理服务实现类 */
@Service("zyglService")
public class ZyglServiceImpl implements IZyglService {
	@Autowired
	private ZyMapper zyMapper;


	/***************** Zy方法组 *****************/
	/**
	 * Zy的条件查询方法
	 * @param zy 承载查询条件的Bean
	 * @return 返回Zy的集合
	 */
	@Override
	public List<Zy> schZy(Zy zy) {
		PageHelper.startPage(zy.getPage(), zy.getPagesize());//设置分页显示
		List<Zy> list=zyMapper.schZy(zy);
		Page<Zy> page = (Page<Zy>)list;//为了设置总记录数先类型强转
		zy.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zy的条件查询方法
	 * @param zy 承载查询条件的Bean
	 * @return 返回Zy的集合
	 */
	@Override
	public List<Zy> schZy2(Zy zy) {
        zy.setPagesize(12);
		PageHelper.startPage(zy.getPage(), zy.getPagesize());//设置分页显示
		List<Zy> list=zyMapper.schZy(zy);
		Page<Zy> page = (Page<Zy>)list;//为了设置总记录数先类型强转
		zy.setDatasize(page.getTotal());
		return list;
	}
	

	/**
	 * Zy的偏好条件查询方法
	 * @param zy 承载查询条件的Bean
	 * @return 返回Zy的集合
	 */
	@Override
	public List<Zy> schphZy(@Param("array")String[] ssxkids, Zy zy) {
		PageHelper.startPage(zy.getPage(), zy.getPagesize());//设置分页显示
		List<Zy> list=zyMapper.schphZy(ssxkids);
		Page<Zy> page = (Page<Zy>)list;//为了设置总记录数先类型强转
		zy.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zy的条件查询方法无分页
	 * @param zy 承载查询条件的Bean
	 * @return 返回Zy的集合
	 */
	@Override
	public List<Zy> schZys(Zy zy) {
		List<Zy> list=zyMapper.schZy(zy);
		return list;
	}
	
	/**
	 * Zy的主键查询方法
	 * @param id 主键值
	 * @return 返回Zy实体
	 */
	@Override
	public Zy schZyById(Integer id) {
		return zyMapper.schZyById(id);
	}
	
	/**
	 * Zy的添加方法
	 * @param zy 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addZy(Zy zy) {
		return zyMapper.addZy(zy);
	}

	/**
	 * Zy的修改方法
	 * @param zy 承载数据的Bean
	 */
	@Override
	public Integer updZy(Zy zy) {
		return zyMapper.updZy(zy);
	}

	/**
	 * Zy的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delZy(Integer id) {
		zyMapper.delZy(id);
	}

	/**
	 * Zy的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delZy(Integer[] ids) {
		zyMapper.delZys(ids);
	}

	/**
	 * Zy的批量审核通过方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void shZysTg(Integer[] ids) {
		zyMapper.shZysTg(ids);
		
	}

	/**
	 * Zy的批量审核不通过方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void shZysBtg(Integer[] ids) {
		zyMapper.shZysBtg(ids);
		
	}


	/**
	 * 上传排行查询方法
	 * @return 返回上传排行的集合
	 */
	@Override
	public List<Map<String, Object>> schScph() {
		return zyMapper.schScph();
	}
	

	/**
	 * 统计资源审核
	 */
	@Override
	public List<Map<String, Object>> schZysh(Zy zy) {
		PageHelper.startPage(zy.getPage(), zy.getPagesize());//设置分页显示
		List<Map<String, Object>> list=zyMapper.schZysh(zy);
		Page<Map<String, Object>> page = (Page<Map<String, Object>>)list;//为了设置总记录数先类型强转
		zy.setDatasize(page.getTotal());
		return list;
	}

	/**
	 * 按类型统计资源大小数量
	 */
	@Override
	public List<Map<String, Object>> schZydxsl(Zy zy) {
		PageHelper.startPage(zy.getPage(), zy.getPagesize());//设置分页显示
		List<Map<String, Object>> list=zyMapper.schZydxsl(zy);
		Page<Map<String, Object>> page = (Page<Map<String, Object>>)list;//为了设置总记录数先类型强转
		zy.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * 按上传人统计资源大小数量
	 */
	@Override
	public List<Map<String, Object>> schScrZydxsl(Zy zy) {
		PageHelper.startPage(zy.getPage(), zy.getPagesize());//设置分页显示
		List<Map<String, Object>> list=zyMapper.schScrZydxsl(zy);
		Page<Map<String, Object>> page = (Page<Map<String, Object>>)list;//为了设置总记录数先类型强转
		zy.setDatasize(page.getTotal());
		return list;
	}

	
	@Autowired
	private ZyplMapper zyplMapper;


	/***************** Zypl方法组 *****************/
	/**
	 * Zypl的条件查询方法
	 * @param zypl 承载查询条件的Bean
	 * @return 返回Zypl的集合
	 */
	@Override
	public List<Zypl> schZypl(Zypl zypl) {
		PageHelper.startPage(zypl.getPage(), zypl.getPagesize());//设置分页显示
		List<Zypl> list=zyplMapper.schZypl(zypl);
		Page<Zypl> page = (Page<Zypl>)list;//为了设置总记录数先类型强转
		zypl.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zypl的条件查询方法无分页
	 * @param zypl 承载查询条件的Bean
	 * @return 返回Zypl的集合
	 */
	@Override
	public List<Zypl> schZypls(Zypl zypl) {
		List<Zypl> list=zyplMapper.schZypl(zypl);
		return list;
	}
	

	/**
	 * Zypl的评论的资源以及评论信息
	 * @param zypl 承载查询条件
	 * @return 返回Zypl的集合
	 */
	@Override
	public List<Zypl> schZyAndZypl(Zypl zypl) {
		PageHelper.startPage(zypl.getPage(), zypl.getPagesize());//设置分页显示
		List<Zypl> list=zyplMapper.schZyAndZypl(zypl);
		Page<Zypl> page = (Page<Zypl>)list;//为了设置总记录数先类型强转
		zypl.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zypl的主键查询方法
	 * @param id 主键值
	 * @return 返回Zypl实体
	 */
	@Override
	public Zypl schZyplById(Integer id) {
		return zyplMapper.schZyplById(id);
	}
	
	/**
	 * Zypl的添加方法
	 * @param zypl 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addZypl(Zypl zypl) {
		return zyplMapper.addZypl(zypl);
	}


	/**
	 * Zypl的评论回复添加方法
	 * @param zypl 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addZyplhf(Zypl zypl) {
		return zyplMapper.addZyplhf(zypl);
	}
	
	/**
	 * Zypl的修改方法
	 * @param zypl 承载数据的Bean
	 */
	@Override
	public void updZypl(Zypl zypl) {
		zyplMapper.updZypl(zypl);
	}

	/**
	 * Zypl的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delZypl(Integer id) {
		zyplMapper.delZypl(id);
	}

	/**
	 * Zypl的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delZypl(Integer[] ids) {
		zyplMapper.delZypls(ids);
	}
	

	/**
	 * Zypl的统计方法
	 * @param zy 承载数据的Bean
	 */
	@Override
	public List<Map<String, Object>> schZyplcs(Zy zy) {
		PageHelper.startPage(zy.getPage(), zy.getPagesize());//设置分页显示
		List<Map<String, Object>> list=zyplMapper.schZyplcs(zy);
		Page<Map<String, Object>> page = (Page<Map<String, Object>>)list;//为了设置总记录数先类型强转
		zy.setDatasize(page.getTotal());
		return list;
	}

	
	@Autowired
	private ZyplhfMapper zyplhfMapper;


	/***************** Zyplhf方法组 *****************/
	/**
	 * Zyplhf的条件查询方法
	 * @param zyplhf 承载查询条件的Bean
	 * @return 返回Zyplhf的集合
	 */
	@Override
	public List<Zyplhf> schZyplhf(Zyplhf zyplhf) {
		PageHelper.startPage(zyplhf.getPage(), zyplhf.getPagesize());//设置分页显示
		List<Zyplhf> list=zyplhfMapper.schZyplhf(zyplhf);
		Page<Zyplhf> page = (Page<Zyplhf>)list;//为了设置总记录数先类型强转
		zyplhf.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zyplhf的主键查询方法
	 * @param id 主键值
	 * @return 返回Zyplhf实体
	 */
	@Override
	public Zyplhf schZyplhfById(Integer id) {
		return zyplhfMapper.schZyplhfById(id);
	}
	
	/**
	 * Zyplhf的添加方法
	 * @param zyplhf 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addZyplhf(Zyplhf zyplhf) {
		return zyplhfMapper.addZyplhf(zyplhf);
	}

	/**
	 * Zyplhf的修改方法
	 * @param zyplhf 承载数据的Bean
	 */
	@Override
	public void updZyplhf(Zyplhf zyplhf) {
		zyplhfMapper.updZyplhf(zyplhf);
	}

	/**
	 * Zyplhf的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delZyplhf(Integer id) {
		zyplhfMapper.delZyplhf(id);
	}

	/**
	 * Zyplhf的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delZyplhf(Integer[] ids) {
		zyplhfMapper.delZyplhfs(ids);
	}


	@Autowired
	private ZyscMapper zyscMapper;


	/***************** Zysc方法组 *****************/
	/**
	 * Zysc的条件查询方法
	 * @param zysc 承载查询条件的Bean
	 * @return 返回Zysc的集合
	 */
	@Override
	public List<Zysc> schZysc(Zysc zysc) {
		PageHelper.startPage(zysc.getPage(), zysc.getPagesize());//设置分页显示
		List<Zysc> list=zyscMapper.schZysc(zysc);
		Page<Zysc> page = (Page<Zysc>)list;//为了设置总记录数先类型强转
		zysc.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zysc的资源和收藏信息查询方法
	 * @param zysc 承载查询条件
	 * @return 返回Zysc的集合
	 */
	@Override
	public List<Zysc> schZyAndZysc(Zysc zysc) {
		PageHelper.startPage(zysc.getPage(), zysc.getPagesize());//设置分页显示
		List<Zysc> list=zyscMapper.schZyAndZysc(zysc);
		Page<Zysc> page = (Page<Zysc>)list;//为了设置总记录数先类型强转
		zysc.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zysc的主键查询方法
	 * @param id 主键值
	 * @return 返回Zysc实体
	 */
	@Override
	public Zysc schZyscById(Integer id) {
		return zyscMapper.schZyscById(id);
	}
	
	/**
	 * Zysc的添加方法
	 * @param zysc 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addZysc(Zysc zysc) {
		return zyscMapper.addZysc(zysc);
	}

	/**
	 * Zysc的修改方法
	 * @param zysc 承载数据的Bean
	 */
	@Override
	public void updZysc(Zysc zysc) {
		zyscMapper.updZysc(zysc);
	}

	/**
	 * Zysc的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delZysc(Integer id) {
		zyscMapper.delZysc(id);
	}

	/**
	 * Zysc的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delZysc(Integer[] ids) {
		zyscMapper.delZyscs(ids);
	}


	/**
	 * Zysc的收藏量方法
	 * @param zyid资源id
	 */
	@Override
	public Integer schZyscCount(String zyid) {
		return zyscMapper.schZyscCount(zyid);
	}
	
	@Autowired
	private ZyxzMapper zyxzMapper;


	/***************** Zyxz方法组 *****************/
	/**
	 * Zyxz的条件查询方法
	 * @param zyxz 承载查询条件的Bean
	 * @return 返回Zyxz的集合
	 */
	@Override
	public List<Zyxz> schZyxz(Zyxz zyxz) {
		PageHelper.startPage(zyxz.getPage(), zyxz.getPagesize());//设置分页显示
		List<Zyxz> list=zyxzMapper.schZyxz(zyxz);
		Page<Zyxz> page = (Page<Zyxz>)list;//为了设置总记录数先类型强转
		zyxz.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zyxz的当前用户下载信息和资源信息
	 * @param zyxz 承载查询条件
	 * @return 返回Zyxz的集合
	 */
	@Override
	public List<Zyxz> schMyZyxz(Zyxz zyxz) {
		PageHelper.startPage(zyxz.getPage(), zyxz.getPagesize());//设置分页显示
		List<Zyxz> list=zyxzMapper.schMyZyxz(zyxz);
		Page<Zyxz> page = (Page<Zyxz>)list;//为了设置总记录数先类型强转
		zyxz.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zyxz的当前用户的资源信息和被下载信息
	 * @param zyxz 承载查询条件
	 * @return 返回Zyxz的集合
	 */
	@Override
	public List<Zyxz> schMyZyAndZyxz(Zyxz zyxz) {
		PageHelper.startPage(zyxz.getPage(), zyxz.getPagesize());//设置分页显示
		List<Zyxz> list=zyxzMapper.schMyZyAndZyxz(zyxz);
		Page<Zyxz> page = (Page<Zyxz>)list;//为了设置总记录数先类型强转
		zyxz.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zyxz的主键查询方法
	 * @param id 主键值
	 * @return 返回Zyxz实体
	 */
	@Override
	public Zyxz schZyxzById(Integer id) {
		return zyxzMapper.schZyxzById(id);
	}
	
	/**
	 * Zyxz的添加方法
	 * @param zyxz 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addZyxz(Zyxz zyxz) {
		return zyxzMapper.addZyxz(zyxz);
	}

	/**
	 * Zyxz的修改方法
	 * @param zyxz 承载数据的Bean
	 */
	@Override
	public void updZyxz(Zyxz zyxz) {
		zyxzMapper.updZyxz(zyxz);
	}

	/**
	 * Zyxz的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delZyxz(Integer id) {
		zyxzMapper.delZyxz(id);
	}

	/**
	 * Zyxz的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delZyxz(Integer[] ids) {
		zyxzMapper.delZyxzs(ids);
	}

	/**
	 * Zyxz的下载量方法
	 * @param zyid 资源id
	 */
	@Override
	public Integer schZyxzCount(String zyid) {
		return zyxzMapper.schZyxzCount(zyid);
	}
	
	/**
	 * Zyxz的统计方法
	 * @param zy 承载数据的Bean
	 */
	@Override
	public List<Map<String, Object>> schZyxzcs(Zy zy) {
		PageHelper.startPage(zy.getPage(), zy.getPagesize());//设置分页显示
		List<Map<String, Object>> list=zyxzMapper.schZyxzcs(zy);
		Page<Map<String, Object>> page = (Page<Map<String, Object>>)list;//为了设置总记录数先类型强转
		zy.setDatasize(page.getTotal());
		return list;
	}

	@Autowired
	private ZyllMapper zyllMapper;


	/***************** Zyll方法组 *****************/
	/**
	 * Zyll的条件查询方法
	 * @param zyll 承载查询条件的Bean
	 * @return 返回Zyll的集合
	 */
	@Override
	public List<Zyll> schZyll(Zyll zyll) {
		PageHelper.startPage(zyll.getPage(), zyll.getPagesize());//设置分页显示
		List<Zyll> list=zyllMapper.schZyll(zyll);
		Page<Zyll> page = (Page<Zyll>)list;//为了设置总记录数先类型强转
		zyll.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zyll的查询浏览的资源以及浏览信息
	 * @param zyll 承载查询条件
	 * @return 返回Zyll的集合
	 */
	@Override
	public List<Zyll> schZyAndZyll(Zyll zyll) {
		PageHelper.startPage(zyll.getPage(), zyll.getPagesize());//设置分页显示
		List<Zyll> list=zyllMapper.schZyAndZyll(zyll);
		Page<Zyll> page = (Page<Zyll>)list;//为了设置总记录数先类型强转
		zyll.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zyll的主键查询方法
	 * @param id 主键值
	 * @return 返回Zyll实体
	 */
	@Override
	public Zyll schZyllById(Integer id) {
		return zyllMapper.schZyllById(id);
	}
	
	/**
	 * Zyll的添加方法
	 * @param zyll 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addZyll(Zyll zyll) {
		return zyllMapper.addZyll(zyll);
	}

	/**
	 * Zyll的修改方法
	 * @param zyll 承载数据的Bean
	 */
	@Override
	public void updZyll(Zyll zyll) {
		zyllMapper.updZyll(zyll);
	}

	/**
	 * Zyll的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delZyll(Integer id) {
		zyllMapper.delZyll(id);
	}

	/**
	 * Zyll的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delZyll(Integer[] ids) {
		zyllMapper.delZylls(ids);
	}

	/**
	 * Zyll的浏览量方法
	 * @param zyid资源id
	 */
	@Override
	public Integer schZyllCount(String zyid) {
		return zyllMapper.schZyllCount(zyid);
	}

	@Autowired
	private TzggMapper tzggMapper;


	/***************** Tzgg方法组 *****************/
	/**
	 * Tzgg的条件查询方法
	 * @param tzgg 承载查询条件的Bean
	 * @return 返回Tzgg的集合
	 */
	@Override
	public List<Tzgg> schTzgg(Tzgg tzgg) {
		PageHelper.startPage(tzgg.getPage(), tzgg.getPagesize());//设置分页显示
		List<Tzgg> list=tzggMapper.schTzgg(tzgg);
		Page<Tzgg> page = (Page<Tzgg>)list;//为了设置总记录数先类型强转
		tzgg.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Tzgg的主键查询方法
	 * @param id 主键值
	 * @return 返回Tzgg实体
	 */
	@Override
	public Tzgg schTzggById(Integer id) {
		return tzggMapper.schTzggById(id);
	}
	

	/**
	 * Tzgg的最新通知公告查询方法
	 * @return 返回Tzgg的集合
	 */
	@Override
	public List<Tzgg> schNewTzgg() {
		return tzggMapper.schNewTzgg();
	}
	
	/**
	 * Tzgg的添加方法
	 * @param tzgg 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addTzgg(Tzgg tzgg) {
		return tzggMapper.addTzgg(tzgg);
	}

	/**
	 * Tzgg的后台添加方法
	 * @param tzgg 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addBackTzgg(Tzgg tzgg) {
		return tzggMapper.addBackTzgg(tzgg);
	}

	/**
	 * Tzgg的后台修改方法
	 * @param tzgg 承载数据的Bean
	 */
	@Override
	public void updBackTzgg(Tzgg tzgg) {
		tzggMapper.updBackTzgg(tzgg);
	}
	
	/**
	 * Tzgg的修改方法
	 * @param tzgg 承载数据的Bean
	 */
	@Override
	public void updTzgg(Tzgg tzgg) {
		tzggMapper.updTzgg(tzgg);
	}

	/**
	 * Tzgg的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delTzgg(Integer id) {
		tzggMapper.delTzgg(id);
	}

	/**
	 * Tzgg的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delTzgg(Integer[] ids) {
		tzggMapper.delTzggs(ids);
	}


	@Autowired
	private XklbMapper xklbMapper;


	/***************** Xklb方法组 *****************/
	/**
	 * Xklb的条件查询方法
	 * @param xklb 承载查询条件的Bean
	 * @return 返回Xklb的集合
	 */
	@Override
	public List<Xklb> schXklb(Xklb xklb) {
		PageHelper.startPage(xklb.getPage(), xklb.getPagesize());//设置分页显示
		List<Xklb> list=xklbMapper.schXklb(xklb);
		Page<Xklb> page = (Page<Xklb>)list;//为了设置总记录数先类型强转
		xklb.setDatasize(page.getTotal());
		return list;
	}
	
	
	/**
	 * Xklb的条件查询方法无分页
	 * @param xklb 承载查询条件的Bean
	 * @return 返回Xklb的集合
	 */
	@Override
	public List<Xklb> schXklbs(Xklb xklb) {
		List<Xklb> list=xklbMapper.schXklb(xklb);
		return list;
	}
	
	/**
	 * Xklb的主键查询方法
	 * @param id 主键值
	 * @return 返回Xklb实体
	 */
	@Override
	public Xklb schXklbById(Integer id) {
		return xklbMapper.schXklbById(id);
	}
	
	/**
	 * Xklb的添加方法
	 * @param xklb 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addXklb(Xklb xklb) {
		return xklbMapper.addXklb(xklb);
	}

	/**
	 * Xklb的修改方法
	 * @param xklb 承载数据的Bean
	 */
	@Override
	public void updXklb(Xklb xklb) {
		xklbMapper.updXklb(xklb);
	}

	/**
	 * Xklb的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delXklb(Integer id) {
		xklbMapper.delXklb(id);
	}

	/**
	 * Xklb的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delXklb(Integer[] ids) {
		xklbMapper.delXklbs(ids);
	}





	@Autowired
	private PhsdMapper phsdMapper;


	/***************** Phsd方法组 *****************/
	/**
	 * Phsd的条件查询方法
	 * @param phsd 承载查询条件的Bean
	 * @return 返回Phsd的集合
	 */
	@Override
	public List<Phsd> schPhsd(Phsd phsd) {
		PageHelper.startPage(phsd.getPage(), phsd.getPagesize());//设置分页显示
		List<Phsd> list=phsdMapper.schPhsd(phsd);
		Page<Phsd> page = (Page<Phsd>)list;//为了设置总记录数先类型强转
		phsd.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Phsd的条件查询方法无分页
	 * @param phsd 承载查询条件的Bean
	 * @return 返回Phsd的集合
	 */
	@Override
	public List<Phsd> schPhsds(Phsd phsd) {
		List<Phsd> list=phsdMapper.schPhsd(phsd);
		return list;
	}
	
	/**
	 * Phsd的主键查询方法
	 * @param id 主键值
	 * @return 返回Phsd实体
	 */
	@Override
	public Phsd schPhsdById(Integer id) {
		return phsdMapper.schPhsdById(id);
	}
	
	/**
	 * Phsd的添加方法
	 * @param phsd 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addPhsd(Phsd phsd) {
		return phsdMapper.addPhsd(phsd);
	}

	/**
	 * Phsd的修改方法
	 * @param phsd 承载数据的Bean
	 */
	@Override
	public void updPhsd(Phsd phsd) {
		phsdMapper.updPhsd(phsd);
	}

	/**
	 * Phsd的用户id修改方法
	 * @param phsd 承载数据的Bean
	 */
	@Override
	public void updPhsdByUser(Phsd phsd) {
		phsdMapper.updPhsdByUser(phsd);
	}

	/**
	 * Phsd的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delPhsd(Integer id) {
		phsdMapper.delPhsd(id);
	}

	/**
	 * Phsd的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delPhsd(Integer[] ids) {
		phsdMapper.delPhsds(ids);
	}

	
	@Override
	public Phsd schPhsdByUserId(Integer userId) {
		return phsdMapper.schPhsdByUserId(userId);
	}

	@Override
	public void updZyConvertOk(List<String> id) {
		zyMapper.updZyConvertOk(id);
	}

	/***
	 * 更新浏览次数
	 * @param id
	 * @return
	 */
	@Override
	public Integer updLlcs(Integer id) {
		return zyMapper.updLlcs(id);
	}

	/***
	 * 更新下载次数
	 * @param id
	 * @return
	 */
	@Override
	public Integer updXzcs(Integer id) {
		return zyMapper.updXzcs(id);
	}

	/***
	 * 更新收藏次数
	 * @param id
	 * @return
	 */
	@Override
	public Integer updSccs(Integer id,int num) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("num", num);
		return zyMapper.updSccs(map);
	}

	/***
	 * 更新评论次数
	 * @param id
	 * @return
	 */
	@Override
	public Integer updPlcs(Integer id) {
		return zyMapper.updPlcs(id);
	}

	/***
	 * 更新点赞次数
	 * @param id
	 * @param num
	 * @return
	 */
	@Override
	public Integer updDzcs(Integer id,int num) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("num", num);
		return zyMapper.updDzcs(map);
	}

	/***
	 * 获取相关资源
	 * @param xkId 学科ID
	 * @return
	 */
	@Override
	public List<Zy> getRelatedZy(Integer xkId) {
		Zy zy = new Zy();
		zy.setSsxkid(xkId);
		zy.setPagesize(PageSizeEnum.RELATED__PAGESIZE.getCount());
		zy.addOrderDescCol("sccs");
		zy.setCondition(" and zyzt=3 and shzt=2 ");
		zy.setPagesize(4);
		List<Zy> relatedZyList = this.schZy(zy); 
		if(relatedZyList==null || relatedZyList.size()==0) {
			zy = new Zy();
			zy.setPagesize(PageSizeEnum.RELATED__PAGESIZE.getCount());
			zy.addOrderDescCol("llcs");
			zy.setCondition(" and zyzt=3 and shzt=2 ");
			relatedZyList = this.schZy(zy); 
		}
		return relatedZyList;
	}


	/***
	 * 取消收藏
	 * @param userId 用户ID
	 * @param zyId 资源ID
	 */
	@Override
	public void delZyscByUserIdZyId(Integer userId, Integer zyId) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("zyId", zyId);
		zyscMapper.delZyscByUserIdZyId(map);
	}

	@Autowired
	private ZydzMapper zydzMapper;


	/***************** Zydz方法组 *****************/
	/**
	 * Zydz的条件查询方法
	 * @param zydz 承载查询条件的Bean
	 * @return 返回Zydz的集合
	 */
	@Override
	public List<Zydz> schZydz(Zydz zydz) {
		PageHelper.startPage(zydz.getPage(), zydz.getPagesize());//设置分页显示
		List<Zydz> list=zydzMapper.schZydz(zydz);
		Page<Zydz> page = (Page<Zydz>)list;//为了设置总记录数先类型强转
		zydz.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Zydz的主键查询方法
	 * @param id 主键值
	 * @return 返回Zydz实体
	 */
	@Override
	public Zydz schZydzById(Integer id) {
		return zydzMapper.schZydzById(id);
	}
	
	/**
	 * Zydz的添加方法
	 * @param zydz 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addZydz(Zydz zydz) {
		return zydzMapper.addZydz(zydz);
	}

	/**
	 * Zydz的修改方法
	 * @param zydz 承载数据的Bean
	 */
	@Override
	public void updZydz(Zydz zydz) {
		zydzMapper.updZydz(zydz);
	}

	/**
	 * Zydz的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delZydz(Integer id) {
		zydzMapper.delZydz(id);
	}

	/**
	 * Zydz的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delZydz(Integer[] ids) {
		zydzMapper.delZydzs(ids);
	}

	@Override
	public void delZydzByUserIdZyId(Integer userId, Integer zyId) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("zyId", zyId);
		zydzMapper.delZydzByUserIdZyId(map);
	}



	@Autowired
	private WjzhMapper wjzhMapper;


	/***************** Wjzh方法组 *****************/
	/**
	 * Wjzh的条件查询方法
	 * @param wjzh 承载查询条件的Bean
	 * @return 返回Wjzh的集合
	 */
	@Override
	public List<Wjzh> schWjzh(Wjzh wjzh) {
		PageHelper.startPage(wjzh.getPage(), wjzh.getPagesize());//设置分页显示
		List<Wjzh> list=wjzhMapper.schWjzh(wjzh);
		Page<Wjzh> page = (Page<Wjzh>)list;//为了设置总记录数先类型强转
		wjzh.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Wjzh的主键查询方法
	 * @param id 主键值
	 * @return 返回Wjzh实体
	 */
	@Override
	public Wjzh schWjzhById(Integer id) {
		return wjzhMapper.schWjzhById(id);
	}
	
	/**
	 * Wjzh的添加方法
	 * @param wjzh 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addWjzh(Wjzh wjzh) {
		return wjzhMapper.addWjzh(wjzh);
	}

	/**
	 * Wjzh的修改方法
	 * @param wjzh 承载数据的Bean
	 */
	@Override
	public void updWjzh(Wjzh wjzh) {
		wjzhMapper.updWjzh(wjzh);
	}

	/**
	 * Wjzh的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delWjzh(Integer id) {
		wjzhMapper.delWjzh(id);
	}

	/**
	 * Wjzh的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delWjzh(Integer[] ids) {
		wjzhMapper.delWjzhs(ids);
	}

	@Override
	public void updWjzhSftb(List<Integer> ids) {
		wjzhMapper.updWjzhSftb(ids);
	}

	/***
	 * 更新资源下载权限
	 * @param zyId 资源ID
	 * @param auth 权限
	 * @param jf 下载积分
	 */
	@Override
	public Integer updateZyDownloadAuth(Integer[] zyIds, Integer auth,Integer jf) {
		Map map = new HashMap();
		map.put("zyIds", zyIds);
		map.put("auth", auth);
		map.put("jf", jf);
		return zyMapper.updateZyDownloadAuth(map);
	}



	@Autowired
	private DjxxMapper djxxMapper;


	/***************** Djxx方法组 *****************/
	/**
	 * Djxx的条件查询方法
	 * @param djxx 承载查询条件的Bean
	 * @return 返回Djxx的集合
	 */
	@Override
	public List<Djxx> schDjxx(Djxx djxx) {
		PageHelper.startPage(djxx.getPage(), djxx.getPagesize());//设置分页显示
		List<Djxx> list=djxxMapper.schDjxx(djxx);
		Page<Djxx> page = (Page<Djxx>)list;//为了设置总记录数先类型强转
		djxx.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Djxx的主键查询方法
	 * @param id 主键值
	 * @return 返回Djxx实体
	 */
	@Override
	public Djxx schDjxxById(Integer id) {
		return djxxMapper.schDjxxById(id);
	}
	
	/**
	 * Djxx的添加方法
	 * @param djxx 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addDjxx(Djxx djxx) {
		return djxxMapper.addDjxx(djxx);
	}

	/**
	 * Djxx的修改方法
	 * @param djxx 承载数据的Bean
	 */
	@Override
	public void updDjxx(Djxx djxx) {
		djxxMapper.updDjxx(djxx);
	}

	/**
	 * Djxx的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delDjxx(Integer id) {
		djxxMapper.delDjxx(id);
	}

	/**
	 * Djxx的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delDjxx(Integer[] ids) {
		djxxMapper.delDjxxs(ids);
	}

	/***
	 * 等级名称是否存在
	 * @param djmc 等级名称
	 * @param id 
	 * @return
	 */
	@Override
	public boolean isDjmcExists(String djmc,Integer id) {
		if(id > 0) {
			Djxx djxx = djxxMapper.schDjxxById(id);
			if(djxx.getDjmc().equals(djmc.trim())){
				return false;
			}else{
				djxx = djxxMapper.schDjxxByDjmc(djmc);
				return djxx==null ? false:true;
			}
		}else {
			Djxx djxx = djxxMapper.schDjxxByDjmc(djmc);
			return djxx==null ? false:true;
		}
	}


	@Autowired
	private YhkzxxMapper yhkzxxMapper;


	/***************** Yhkzxx方法组 *****************/
	/**
	 * Yhkzxx的条件查询方法
	 * @param yhkzxx 承载查询条件的Bean
	 * @return 返回Yhkzxx的集合
	 */
	@Override
	public List<Yhkzxx> schYhkzxx(Yhkzxx yhkzxx) {
		PageHelper.startPage(yhkzxx.getPage(), yhkzxx.getPagesize());//设置分页显示
		List<Yhkzxx> list=yhkzxxMapper.schYhkzxx(yhkzxx);
		Page<Yhkzxx> page = (Page<Yhkzxx>)list;//为了设置总记录数先类型强转
		yhkzxx.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Yhkzxx的主键查询方法
	 * @param id 主键值
	 * @return 返回Yhkzxx实体
	 */
	@Override
	public Yhkzxx schYhkzxxById(Integer id) {
		return yhkzxxMapper.schYhkzxxById(id);
	}
	
	/**
	 * Yhkzxx的添加方法
	 * @param yhkzxx 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addYhkzxx(Yhkzxx yhkzxx) {
		return yhkzxxMapper.addYhkzxx(yhkzxx);
	}

	/**
	 * Yhkzxx的修改方法
	 * @param yhkzxx 承载数据的Bean
	 */
	@Override
	public void updYhkzxx(Yhkzxx yhkzxx) {
		yhkzxxMapper.updYhkzxx(yhkzxx);
	}

	/**
	 * Yhkzxx的单记录删除方法
	 * @param id 要删除的主键值
	 */
	@Override
	public void delYhkzxx(Integer id) {
		yhkzxxMapper.delYhkzxx(id);
	}

	/**
	 * Yhkzxx的批量删除方法
	 * @param ids 主键值的数组
	 */
	@Override
	public void delYhkzxx(Integer[] ids) {
		yhkzxxMapper.delYhkzxxs(ids);
	}

	/**
	 * 更新用户积分
	 * @param yhkzxx
	 */
	@Override
	public void updYhjf(Yhkzxx yhkzxx) {
		//变动的积分
		Integer jfExchanged = yhkzxx.getJf();
		//重置积分，只按用户ID查询
		yhkzxx.setJf(null);
		List<Yhkzxx> yhkzxxList = this.schYhkzxx(yhkzxx);
		//重新设置变动积分
		yhkzxx.setJf(jfExchanged);
		if(yhkzxxList==null || yhkzxxList.size() == 0) {
			this.addYhkzxx(yhkzxx);
		}else{
			yhkzxx.setId(yhkzxxList.get(0).getId());
			this.updYhkzxx(yhkzxx);
		}
	}

	@Override
	public Djxx schDjxxByJf(Integer jf) {
		return djxxMapper.schDjxxByJf(jf);
	}



	@Autowired
	private WzszMapper wzszMapper;


	/***************** Wzsz方法组 *****************/
	/**
	 * Wzsz的条件查询方法
	 * @param wzsz 承载查询条件的Bean
	 * @return 返回Wzsz的集合
	 */
	@Override
	public List<Wzsz> schWzsz(Wzsz wzsz) {
		PageHelper.startPage(wzsz.getPage(), wzsz.getPagesize());//设置分页显示
		List<Wzsz> list=wzszMapper.schWzsz(wzsz);
		Page<Wzsz> page = (Page<Wzsz>)list;//为了设置总记录数先类型强转
		wzsz.setDatasize(page.getTotal());
		return list;
	}
	
	/**
	 * Wzsz的主键查询方法
	 * @param id 主键值
	 * @return 返回Wzsz实体
	 */
	@Override
	public Wzsz schWzszById(Integer id) {
		return wzszMapper.schWzszById(id);
	}
	
	/**
	 * Wzsz的添加方法
	 * @param wzsz 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	@Override
	public Integer addWzsz(Wzsz wzsz) {
		return wzszMapper.addWzsz(wzsz);
	}

	/**
	 * Wzsz的修改方法
	 * @param wzsz 承载数据的Bean
	 */
	@Override
	public void updWzsz(Wzsz wzsz) {
		wzszMapper.updWzsz(wzsz);
	}

}//end