package com.qtrmoon.zygl.serdao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
/** 资源管理服务接口 */
public interface IZyglService {
	
	/***************** Zy方法组 *****************/
	/**
	 * Zy的条件查询方法
	 * @param zy 承载查询条件的Bean
	 * @return 返回Zy的集合
	 */
	public List<Zy> schZy(Zy zy);
	
	/**
	 * Zy的条件查询方法
	 * @param zy 承载查询条件的Bean
	 * @return 返回Zy的集合
	 */
	public List<Zy> schZy2(Zy zy);
	
	/**
	 * Zy的偏好条件查询方法
	 * @param zy 承载查询条件
	 * @return 返回Zy的集合
	 */
	public List<Zy> schphZy(@Param("array")String[] ssxkids,Zy zy);
	
	/**
	 * Zy的条件查询方法无分页
	 * @param zy 承载查询条件的Bean
	 * @return 返回Zy的集合
	 */
	public List<Zy> schZys(Zy zy);
	
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
	public void delZy(Integer[] ids);

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
	 * @param id 资源ID
	 * @param num 次数
	 * @return
	 */
	public Integer updSccs(Integer id,int num);
	
	/***
	 * 更新评论次数
	 * @param id
	 * @return
	 */
	public Integer updPlcs(Integer id);
	
	/***
	 * 更新点赞次数
	 * @param id
	 * @return
	 */
	public Integer updDzcs(Integer id,int num);
	

	/**
	 * 上传排行查询方法
	 * @return 返回上传排行的集合
	 */
	public List<Map<String,Object>> schScph();
	
	/**
	 * Zyll的浏览量方法
	 * @param zyid资源id
	 */
	public Integer schZyllCount(@Param("zyid")String zyid);
	
	
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
	
	/***************** Zypl方法组 *****************/
	/**
	 * Zypl的条件查询方法
	 * @param zypl 承载查询条件的Bean
	 * @return 返回Zypl的集合
	 */
	public List<Zypl> schZypl(Zypl zypl);
	
	/**
	 * Zypl的条件查询方法无分页
	 * @param zypl 承载查询条件的Bean
	 * @return 返回Zypl的集合
	 */
	public List<Zypl> schZypls(Zypl zypl);
	
	/**
	 * Zypl的评论的资源以及评论信息
	 * @param zypl 承载查询条件
	 * @return 返回Zypl的集合
	 */
	public List<Zypl> schZyAndZypl(Zypl zypl);
	
	
	/**
	 * Zypl的主键查询方法
	 * @param id 主键值
	 * @return 返回Zypl实体
	 */
	public Zypl schZyplById(Integer id);
	
	/**
	 * Zypl的添加方法
	 * @param zypl 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZypl(Zypl zypl);
	
	/**
	 * Zypl的评论回复添加方法
	 * @param zypl 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZyplhf(Zypl zypl);
	
	/**
	 * Zypl的修改方法
	 * @param zypl 承载数据的Bean
	 */
	public void updZypl(Zypl zypl);
	
	/**
	 * Zypl的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZypl(Integer id);
	
	/**
	 * Zypl的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZypl(Integer[] ids);
	
	/**
	 * 统计资源评论
	 */
	public List<Map<String,Object>> schZyplcs(@Param("zy") Zy zy);
	
	
	/***************** Zyplhf方法组 *****************/
	/**
	 * Zyplhf的条件查询方法
	 * @param zyplhf 承载查询条件的Bean
	 * @return 返回Zyplhf的集合
	 */
	public List<Zyplhf> schZyplhf(Zyplhf zyplhf);
	
	/**
	 * Zyplhf的主键查询方法
	 * @param id 主键值
	 * @return 返回Zyplhf实体
	 */
	public Zyplhf schZyplhfById(Integer id);
	
	/**
	 * Zyplhf的添加方法
	 * @param zyplhf 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZyplhf(Zyplhf zyplhf);
	
	/**
	 * Zyplhf的修改方法
	 * @param zyplhf 承载数据的Bean
	 */
	public void updZyplhf(Zyplhf zyplhf);
	
	/**
	 * Zyplhf的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZyplhf(Integer id);
	
	/**
	 * Zyplhf的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZyplhf(Integer[] ids);


	
	/***************** Zysc方法组 *****************/
	/**
	 * Zysc的条件查询方法
	 * @param zysc 承载查询条件的Bean
	 * @return 返回Zysc的集合
	 */
	public List<Zysc> schZysc(Zysc zysc);
	
	/**
	 * Zysc的资源和收藏信息查询方法
	 * @param zysc 承载查询条件
	 * @return 返回Zysc的集合
	 */
	public List<Zysc> schZyAndZysc(Zysc zysc);
	
	/**
	 * Zysc的主键查询方法
	 * @param id 主键值
	 * @return 返回Zysc实体
	 */
	public Zysc schZyscById(Integer id);
	
	/**
	 * Zysc的添加方法
	 * @param zysc 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZysc(Zysc zysc);
	
	/**
	 * Zysc的修改方法
	 * @param zysc 承载数据的Bean
	 */
	public void updZysc(Zysc zysc);
	
	/**
	 * Zysc的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZysc(Integer id);
	
	/**
	 * Zysc的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZysc(Integer[] ids);


	/**
	 * Zysc的收藏量方法
	 * @param zyid资源id
	 */
	public Integer schZyscCount(@Param("zyid")String zyid);
	
	
	/***************** Zyxz方法组 *****************/
	/**
	 * Zyxz的条件查询方法
	 * @param zyxz 承载查询条件的Bean
	 * @return 返回Zyxz的集合
	 */
	public List<Zyxz> schZyxz(Zyxz zyxz);
	
	/**
	 * Zyxz的当前用户下载信息和资源信息
	 * @param zyxz 承载查询条件
	 * @return 返回Zyxz的集合
	 */
	public List<Zyxz> schMyZyxz(Zyxz zyxz);
	
	/**
	 * Zyxz的当前用户的资源信息和被下载信息
	 * @param zyxz 承载查询条件
	 * @return 返回Zyxz的集合
	 */
	public List<Zyxz> schMyZyAndZyxz(Zyxz zyxz);
	
	/**
	 * Zyxz的主键查询方法
	 * @param id 主键值
	 * @return 返回Zyxz实体
	 */
	public Zyxz schZyxzById(Integer id);
	
	/**
	 * Zyxz的添加方法
	 * @param zyxz 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZyxz(Zyxz zyxz);
	
	/**
	 * Zyxz的修改方法
	 * @param zyxz 承载数据的Bean
	 */
	public void updZyxz(Zyxz zyxz);
	
	/**
	 * Zyxz的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZyxz(Integer id);
	
	/**
	 * Zyxz的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZyxz(Integer[] ids);


	/**
	 * Zyxz的下载量方法
	 * @param zyid资源id
	 */
	public Integer schZyxzCount(@Param("zyid")String zyid);
	
	
	/**
	 * 统计资源下载
	 */
	public List<Map<String,Object>> schZyxzcs(Zy zy);
	
	/***************** Zyll方法组 *****************/
	/**
	 * Zyll的条件查询方法
	 * @param zyll 承载查询条件的Bean
	 * @return 返回Zyll的集合
	 */
	public List<Zyll> schZyll(Zyll zyll);
	
	/**
	 * Zyll的查询浏览的资源以及浏览信息
	 * @param zyll 承载查询条件
	 * @return 返回Zyll的集合
	 */
	public List<Zyll> schZyAndZyll(Zyll zyll);
	
	/**
	 * Zyll的主键查询方法
	 * @param id 主键值
	 * @return 返回Zyll实体
	 */
	public Zyll schZyllById(Integer id);
	
	/**
	 * Zyll的添加方法
	 * @param zyll 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZyll(Zyll zyll);
	
	/**
	 * Zyll的修改方法
	 * @param zyll 承载数据的Bean
	 */
	public void updZyll(Zyll zyll);
	
	/**
	 * Zyll的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZyll(Integer id);
	
	/**
	 * Zyll的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZyll(Integer[] ids);


	
	/***************** Tzgg方法组 *****************/
	/**
	 * Tzgg的条件查询方法
	 * @param tzgg 承载查询条件的Bean
	 * @return 返回Tzgg的集合
	 */
	public List<Tzgg> schTzgg(Tzgg tzgg);
	
	/**
	 * Tzgg的最新通知公告查询方法
	 * @return 返回Tzgg的集合
	 */
	public List<Tzgg> schNewTzgg();
	
	/**
	 * Tzgg的主键查询方法
	 * @param id 主键值
	 * @return 返回Tzgg实体
	 */
	public Tzgg schTzggById(Integer id);
	
	/**
	 * Tzgg的添加方法
	 * @param tzgg 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addTzgg(Tzgg tzgg);
	
	/**
	 * Tzgg后台的添加方法
	 * @param tzgg 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addBackTzgg(Tzgg tzgg);
	
	/**
	 * Tzgg的后台修改方法
	 * @param tzgg 承载数据的Bean
	 */
	public void updBackTzgg(Tzgg tzgg);
	
	/**
	 * Tzgg的修改方法
	 * @param tzgg 承载数据的Bean
	 */
	public void updTzgg(Tzgg tzgg);
	
	/**
	 * Tzgg的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delTzgg(Integer id);
	
	/**
	 * Tzgg的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delTzgg(Integer[] ids);


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
	
	/***************** Xklb方法组 *****************/
	/**
	 * Xklb的条件查询方法
	 * @param xklb 承载查询条件的Bean
	 * @return 返回Xklb的集合
	 */
	public List<Xklb> schXklb(Xklb xklb);
	
	/**
	 * Xklb的条件查询方法
	 * @param xklb 承载查询条件的Bean
	 * @return 返回Xklb的集合
	 */
	public List<Xklb> schXklbs(Xklb xklb);
	
	/**
	 * Xklb的主键查询方法
	 * @param id 主键值
	 * @return 返回Xklb实体
	 */
	public Xklb schXklbById(Integer id);
	
	/**
	 * Xklb的添加方法
	 * @param xklb 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addXklb(Xklb xklb);
	
	/**
	 * Xklb的修改方法
	 * @param xklb 承载数据的Bean
	 */
	public void updXklb(Xklb xklb);
	
	/**
	 * Xklb的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delXklb(Integer id);
	
	/**
	 * Xklb的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delXklb(Integer[] ids);


	
	/***************** Phsd方法组 *****************/
	/**
	 * Phsd的条件查询方法
	 * @param phsd 承载查询条件的Bean
	 * @return 返回Phsd的集合
	 */
	public List<Phsd> schPhsd(Phsd phsd);
	
	/**
	 * Phsd的条件查询方法无分页
	 * @param phsd 承载查询条件的Bean
	 * @return 返回Phsd的集合
	 */
	public List<Phsd> schPhsds(Phsd phsd);
	
	/**
	 * Phsd的主键查询方法
	 * @param id 主键值
	 * @return 返回Phsd实体
	 */
	public Phsd schPhsdById(Integer id);
	
	/**
	 * Phsd的添加方法
	 * @param phsd 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addPhsd(Phsd phsd);
	
	/**
	 * Phsd的修改方法
	 * @param phsd 承载数据的Bean
	 */
	public void updPhsd(Phsd phsd);
	
	/**
	 * Phsd的根据用户id修改方法
	 * @param phsd 承载数据的Bean
	 */
	public void updPhsdByUser(Phsd phsd);
	
	/**
	 * Phsd的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delPhsd(Integer id);
	
	/**
	 * Phsd的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delPhsd(Integer[] ids);

	/***
	 * 获取用户的偏好设定
	 * @param userId
	 * @return
	 */
	public Phsd schPhsdByUserId(Integer userId);
	
	/***
	 * 更新文件转换成功
	 * @param id
	 * @return
	 */
	public void updZyConvertOk(List<String> id);
	
	
	/***
	 * 获取相关资源
	 * @param xkId 学科ID
	 * @return
	 */
	public List<Zy> getRelatedZy(Integer xkId);


	/***
	 * 取消收藏
	 * @param userId 用户ID
	 * @param zyId 资源ID
	 */
	public void delZyscByUserIdZyId(Integer userId, Integer zyId);


	
	/***************** Zydz方法组 *****************/
	/**
	 * Zydz的条件查询方法
	 * @param zydz 承载查询条件的Bean
	 * @return 返回Zydz的集合
	 */
	public List<Zydz> schZydz(Zydz zydz);
	
	/**
	 * Zydz的主键查询方法
	 * @param id 主键值
	 * @return 返回Zydz实体
	 */
	public Zydz schZydzById(Integer id);
	
	/**
	 * Zydz的添加方法
	 * @param zydz 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addZydz(Zydz zydz);
	
	/**
	 * Zydz的修改方法
	 * @param zydz 承载数据的Bean
	 */
	public void updZydz(Zydz zydz);
	
	/**
	 * Zydz的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delZydz(Integer id);
	
	/**
	 * Zydz的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delZydz(Integer[] ids);

	
	/***
	 * 取消点赞
	 * @param userId 用户ID
	 * @param zyId 资源ID
	 */
	public void delZydzByUserIdZyId(Integer userId, Integer zyId);


	
	/***************** Wjzh方法组 *****************/
	/**
	 * Wjzh的条件查询方法
	 * @param wjzh 承载查询条件的Bean
	 * @return 返回Wjzh的集合
	 */
	public List<Wjzh> schWjzh(Wjzh wjzh);
	
	/**
	 * Wjzh的主键查询方法
	 * @param id 主键值
	 * @return 返回Wjzh实体
	 */
	public Wjzh schWjzhById(Integer id);
	
	/**
	 * Wjzh的添加方法
	 * @param wjzh 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addWjzh(Wjzh wjzh);
	
	/**
	 * Wjzh的修改方法
	 * @param wjzh 承载数据的Bean
	 */
	public void updWjzh(Wjzh wjzh);
	
	/**
	 * Wjzh的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delWjzh(Integer id);
	
	/**
	 * Wjzh的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delWjzh(Integer[] ids);
	
	/**
	 * Wjzh的修改方法
	 * @param wjzh 承载数据的Bean
	 */
	public void updWjzhSftb(List<Integer> ids);

	/***
	 * 更新资源下载权限
	 * @param zyId 资源ID 数组
	 * @param auth 权限
	 * @param jf 下载积分
	 */
	public Integer updateZyDownloadAuth(Integer[] zyIds, Integer auth,Integer jf);




	
	/***************** Djxx方法组 *****************/
	/**
	 * Djxx的条件查询方法
	 * @param djxx 承载查询条件的Bean
	 * @return 返回Djxx的集合
	 */
	public List<Djxx> schDjxx(Djxx djxx);
	
	/**
	 * Djxx的主键查询方法
	 * @param id 主键值
	 * @return 返回Djxx实体
	 */
	public Djxx schDjxxById(Integer id);
	
	/**
	 * Djxx的添加方法
	 * @param djxx 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addDjxx(Djxx djxx);
	
	/**
	 * Djxx的修改方法
	 * @param djxx 承载数据的Bean
	 */
	public void updDjxx(Djxx djxx);
	
	/**
	 * Djxx的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delDjxx(Integer id);
	
	/**
	 * Djxx的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delDjxx(Integer[] ids);

	/***
	 * 等级名称是否存在
	 * @param djmc 等级名称
	 * @param id 
	 * @return
	 */
	public boolean isDjmcExists(String djmc,Integer id);




	
	/***************** Yhkzxx方法组 *****************/
	/**
	 * Yhkzxx的条件查询方法
	 * @param yhkzxx 承载查询条件的Bean
	 * @return 返回Yhkzxx的集合
	 */
	public List<Yhkzxx> schYhkzxx(Yhkzxx yhkzxx);
	
	/**
	 * Yhkzxx的主键查询方法
	 * @param id 主键值
	 * @return 返回Yhkzxx实体
	 */
	public Yhkzxx schYhkzxxById(Integer id);
	
	/**
	 * Yhkzxx的添加方法
	 * @param yhkzxx 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addYhkzxx(Yhkzxx yhkzxx);
	
	/**
	 * Yhkzxx的修改方法
	 * @param yhkzxx 承载数据的Bean
	 */
	public void updYhkzxx(Yhkzxx yhkzxx);
	
	/**
	 * Yhkzxx的单记录删除方法
	 * @param id 要删除的主键值
	 */
	public void delYhkzxx(Integer id);
	
	/**
	 * Yhkzxx的批量删除方法
	 * @param ids 主键值的数组
	 */
	public void delYhkzxx(Integer[] ids);

	/**
	 * 更新用户积分
	 * @param yhkzxx
	 */
	public void updYhjf(Yhkzxx yhkzxx);

	/***
	 * 按积分查询
	 * @param jf 积分
	 * @return
	 */
	public Djxx schDjxxByJf(Integer jf);


	
	/***************** Wzsz方法组 *****************/
	/**
	 * Wzsz的条件查询方法
	 * @param wzsz 承载查询条件的Bean
	 * @return 返回Wzsz的集合
	 */
	public List<Wzsz> schWzsz(Wzsz wzsz);
	
	/**
	 * Wzsz的主键查询方法
	 * @param id 主键值
	 * @return 返回Wzsz实体
	 */
	public Wzsz schWzszById(Integer id);
	
	/**
	 * Wzsz的添加方法
	 * @param wzsz 承载数据的Bean，执行添加后会更新入库后的主键值
	 * @return 返回影响的行数
	 */
	public Integer addWzsz(Wzsz wzsz);
	
	/**
	 * Wzsz的修改方法
	 * @param wzsz 承载数据的Bean
	 */
	public void updWzsz(Wzsz wzsz);

}//end