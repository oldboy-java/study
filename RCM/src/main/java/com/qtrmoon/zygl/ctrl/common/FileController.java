package com.qtrmoon.zygl.ctrl.common;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tk.json.JsonHelper;
import tk.upload.UploadResponseVo;
import tk.upload.XFileUtils;

import com.google.gson.Gson;
import com.qtrmoon.common.event.FileConvertEvent;
import com.qtrmoon.zygl.pojo.Zy;

/***
 * 文件上传控制器
 *
 */
@Controller
@RequestMapping("file")
public class FileController {

	
	@Autowired  
    private ApplicationContext applicationContext; 
	
	@Value("${fileUploadUrl}")
	private String fileUploadUrl;//文件服务上传路径
	
	@Value("${project}")
	private String project; //文件上传项目
	
	@Value("${remoteFileBaseUrl}")
	private String remoteFileBaseUrl; //远程文件基路径
	
	
	
	/***
	 * 文件上传
	 * @param file 上传文件名，在表单提交时文件名必须是file
	 * @param fm 是否是上传封面
	 * @param request
	 * @return 返回上传文件路径的Result对象
	 * @throws Exception
	 */
	@RequestMapping(value="upload.action",method=RequestMethod.POST)
	@ResponseBody
	public String uploadFile(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response,@RequestParam(name="fm",defaultValue="false") boolean fm) throws Exception{
		Map<String,InputStream> fileHashMap = new HashMap<String,InputStream>();
		fileHashMap.put(file.getOriginalFilename(),file.getInputStream());
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("project", project);
		String result =  XFileUtils.uploadFileStreamToRemoteService(fileHashMap, params, fileUploadUrl);
		
		List<UploadResponseVo> UploadResponseVoList = JsonHelper.getJsonList(result, "data", UploadResponseVo.class);
		UploadResponseVo uploadResponseVo = null;
		if(UploadResponseVoList != null && UploadResponseVoList.size() > 0) {
			uploadResponseVo = UploadResponseVoList.get(0);
		}
		
		Zy zy = new Zy();
		zy.setZydz(remoteFileBaseUrl+uploadResponseVo.getFilePath());
		zy.setHzm(uploadResponseVo.getFileType());
		zy.setWjmc(uploadResponseVo.getFileName());
		
		//发布事件
		if(!fm){
			applicationContext.publishEvent(new FileConvertEvent(zy));
		}
		return  new Gson().toJson(uploadResponseVo);
	}
    
	
	/**
	 * 获取文件流
	 * @param filename
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/getFileBinnary.action")
	public void getFileBinnary(String filename,HttpServletRequest request,HttpServletResponse response){
		if(filename != null){
			try{
				File file = new File(filename);
				if(file.exists()){
					IOUtils.copy(new FileInputStream(filename), response.getOutputStream());
				}else{
					System.out.println("文件不存在！不产生数据流输出到前台页面。缺失文件及路径为："+filename);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
