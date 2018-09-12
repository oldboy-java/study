package com.qtrmoon.common.event;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.qtrmoon.util.DocConverter;
import com.qtrmoon.util.FfmpegVideoConverter;
import com.qtrmoon.zygl.pojo.Wjzh;
import com.qtrmoon.zygl.pojo.Zy;
import com.qtrmoon.zygl.serdao.IZyglService;

/***
 * 文件转换事件监听器
 */
@Component
public class FileConvertListener implements ApplicationListener<FileConvertEvent> {

	@Autowired
	private IZyglService zyglService;
	
	@Value("${ffmpegPath}")
	private String ffmpegPath;
	
	@Value("${targetVideoType}")
	private int targetVideoType;
	
	@Override
	@Async  //防止@Async重复扫描，否则异步失效     出现非异步参考：https://segmentfault.com/a/1190000008981884
	public void onApplicationEvent(FileConvertEvent fileConvertEvent) {
		Zy zy = (Zy)fileConvertEvent.getSource();
		//不是PDF文件的，需要执行文件转换
		boolean isOk = false;
		if(zy.getHzm().toLowerCase().equals(".doc") || zy.getHzm().toLowerCase().equals(".docx") 
				||zy.getHzm().toLowerCase().equals(".ppt") || zy.getHzm().toLowerCase().equals(".pptx")
				|| zy.getHzm().toLowerCase().equals(".xls") || zy.getHzm().toLowerCase().equals(".xlsx")){
			isOk = new DocConverter(zy.getZydz()).conver(true);
		}else{
			isOk = new FfmpegVideoConverter(zy.getZydz(), null, ffmpegPath).convert(targetVideoType);
		}
		
	   //记录文件转换日志
		Wjzh wjzh = new Wjzh();
		wjzh.setZhsj(new Date());
		wjzh.setWjid(zy.getZydz());
		wjzh.setWjmc(zy.getWjmc());
		wjzh.setZhjg(isOk==true?1:0);
		zyglService.addWjzh(wjzh);
	}

}
