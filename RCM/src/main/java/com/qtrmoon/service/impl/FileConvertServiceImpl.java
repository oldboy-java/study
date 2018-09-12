package com.qtrmoon.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.qtrmoon.service.FileConvertService;
import com.qtrmoon.util.DocConverter;
import com.qtrmoon.zygl.pojo.Wjzh;
import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.serdao.IZyglService;
@Component
public class FileConvertServiceImpl implements FileConvertService{
	
	@Autowired
	private IZyglService zyglService;
	
	@Value("${remoteFileBaseUrl}")
	private String remoteFileBaseUrl; //远程文件基路径
	
	
	/**
	 * 手动转换文档格式方法
	 * @param zydz
	 * @return
	 */
	@Override
	public boolean convertResourceByManual(String zydz){

		boolean isOk = false;   //设置转换成功为false
		
		Zy zy=new Zy();
		zy.setZydz(zydz);
		List<Zy> zhzy=zyglService.schZy(zy);  //根据资源地址查询资源
		
		Wjzh zh = new Wjzh();
		zh.setWjid(remoteFileBaseUrl+zydz);
		List<Wjzh> schzh=zyglService.schWjzh(zh);  //根据资源地址查询文件转换
		if(schzh.size()>0){     //当查询文件转换的集合大于0时说明之前已经转换
			if(schzh.get(0).getZhjg()==1){   //集合中的转换结果为1时（转换成功）
				List<String> urlList = new ArrayList<String>();   
				List<Integer>  ids = new ArrayList<Integer>();  
				urlList.add(zydz);
				ids.add(schzh.get(0).getId());
				zyglService.updZyConvertOk(urlList);  //调用方法将资源里的转换成功设置为1（成功）
				zyglService.updWjzhSftb(ids);   //调用方法将文件转换的是否同步修改为1（同步）
				isOk=true;
			}else if(schzh.get(0).getZhjg()==0){   //集合中的转换结果为0时（转换失败）
				isOk = new DocConverter(remoteFileBaseUrl+zydz).conver(true);   //调用方法再次进行转换
				Wjzh wjzh = new Wjzh();
				wjzh.setId(schzh.get(0).getId());   //设置文件转换id
				wjzh.setZhsj(new Date());     //设置转换时间
				wjzh.setWjid(remoteFileBaseUrl + zydz);            //设置资源地址
				wjzh.setWjmc(zhzy.get(0).getWjmc());   //设置文件名称
				wjzh.setZhjg(isOk==true?1:0);    //设置转换结果
				zyglService.updWjzh(wjzh);     //修改文件转换信息
				if(isOk==true){      //如果再次转换成功
					List<Integer>  ids = new ArrayList<Integer>();    
					List<String> urlList = new ArrayList<String>();
					ids.add(schzh.get(0).getId());
					urlList.add(zydz);
					zyglService.updZyConvertOk(urlList);  //调用方法将资源里的转换成功设置为1（成功）
					zyglService.updWjzhSftb(ids);    //调用方法将文件转换的是否同步修改为1（同步）
				}
			}
		}else{               //否则没有进行转换过
			isOk = new DocConverter(remoteFileBaseUrl + zydz).conver(true);     //调用方法进行转换
			Wjzh wjzh = new Wjzh();      
			wjzh.setZhsj(new Date());   //设置转换时间
			wjzh.setWjid(remoteFileBaseUrl+zydz);      //设置资源地址
			wjzh.setWjmc(zhzy.get(0).getWjmc());    //设置文件名称
			wjzh.setZhjg(isOk==true?1:0);     //设置转换结果
			zyglService.addWjzh(wjzh);   //添加文件转换信息
			
			Wjzh wjzh2 = new Wjzh();
			wjzh2.setWjid(remoteFileBaseUrl+zydz);  
			List<Wjzh> schWjzh=zyglService.schWjzh(wjzh2);  //根据资源地址查询文件转换
			if(schWjzh.get(0).getZhjg()==1){       //集合中的转换结果为1时（转换成功） 
				List<String> urlList = new ArrayList<String>();
				List<Integer>  ids = new ArrayList<Integer>();
				urlList.add(zydz);
				ids.add(schWjzh.get(0).getId());
				zyglService.updZyConvertOk(urlList);   //调用方法将资源里的转换成功设置为1（成功）
				zyglService.updWjzhSftb(ids);    //调用方法将文件转换的是否同步修改为1（同步）
				isOk=true;    //设置转换成功为true
			}
		}
		return isOk;
	}
}
