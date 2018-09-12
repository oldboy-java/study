package com.qtrmoon.job;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.qtrmoon.zygl.pojo.Wjzh;
import com.qtrmoon.zygl.serdao.IZyglService;

@Component
public class RsyncFileConvertResultJob {

	@Autowired
	private IZyglService zyglService;								//声明模块Service实例
	
	@Value("${remoteFileBaseUrl}")
	private String remoteFileBaseUrl; //远程文件基路径
	
	
	public void init(){
		//获取转换成功且未同步的记录
		Wjzh wjzh = new Wjzh();
		wjzh.setZhjg(1);
		wjzh.setSftb(0);
		List<Wjzh> wjzhList = zyglService.schWjzh(wjzh);
		List<String> urlList = new ArrayList<String>();
		List<Integer>  ids = new ArrayList<Integer>();
		if(wjzhList!=null && wjzhList.size() > 0){
			for(Wjzh wjzh2 :wjzhList ){
				String url = wjzh2.getWjid().substring(remoteFileBaseUrl.length());
				urlList.add(url);
				ids.add(wjzh2.getId());
			}
		}
		
		//同步资源转换状态
		if(urlList!=null && urlList.size() >0){
			zyglService.updZyConvertOk(urlList);
		}
		
		//更新处理完标志
		if(ids!=null && ids.size() >0){
			zyglService.updWjzhSftb(ids);
		}
	}
}
