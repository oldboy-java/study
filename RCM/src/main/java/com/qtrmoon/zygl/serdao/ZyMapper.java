package com.qtrmoon.zygl.serdao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Zy;
/** 资源表实体映射 */
@Component
public interface ZyMapper {
	/**
	 * Zy的条件查询方法
	 * @param zy 承载查询条件
	 * @return 返回Zy的集合
	 */
	public List<Zy> schZy(Zy zy);
	
	/**
	 * Zy的偏好条件查询方法
	 * @param zy 承载查询条件
	 * @return 返回Zy的集合
	 */
	public List<Zy> schphZy(String[] ssxkids);
	
	/**
	 * Zy的主键查询方法
	 * @param id 主键值
	 * @return 返回Zy实体
	 */
	public Zy schZyById(Integer id);
	
	/**
	 * Zy的添加方法
	 * @param zy 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZy(Zy zy);
	
	/**
	 * Zy的修改方法
	 * @param zy 承载数据的Bean
	 */
	public Integer updZy(Zy zy);
	
	/**
	 * Zy的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZy(Integer id);
	
	/**
	 * Zy的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZys(Integer[] ids);
	
	/**
	 * Zy的批量审核通过方法
	 * @param ids 主键值的数组
	 */
	public void shZysTg(Integer[] ids);
	
	/**
	 * Zy的批量审核不通过方法
	 * @param ids 主键值的数组
	 */
	public void shZysBtg(Integer[] ids);
	
	/***
	 * 更新文件转换成功
	 * @param id
	 * @return
	 */
	public void updZyConvertOk(List<String> id);
	
	/***
	 * 更新浏览次数
	 * @param id
	 * @return
	 */
	public Integer updLlcs(Integer id);
	
	/***
	 * 更新下载次数
	 * @param id
	 * @return
	 */
	public Integer updXzcs(Integer id);
	
	/***
	 * 更新收藏次数
	 * @return
	 */
	public Integer updSccs(Map map);
	
	/***
	 * 更新评论次数
	 * @param id
	 * @return
	 */
	public Integer updPlcs(Integer id);
	
	/***
	 * 更新点赞次数
	 * @return
	 */
	public Integer updDzcs(Map map);
	
	/**
	 * 上传排行查询方法
	 * @return 返回上传排行的集合
	 */
	public List<Map<String,Object>> schScph();

	/**
	 * 更新资源下载权限
	 * @param map
	 * @return
	 */
	public Integer updateZyDownloadAuth(Map map);
	
	/**
	 * 统计资源审核
	 */
	public List<Map<String,Object>> schZysh(Zy zy);
	
	/**
	 * 按类型统计资源大小数量
	 */
	public List<Map<String,Object>> schZydxsl(Zy zy);
	
	/**
	 * 按上传人统计资源大小数量
	 */
	public List<Map<String,Object>> schScrZydxsl(Zy zy);
	
}
