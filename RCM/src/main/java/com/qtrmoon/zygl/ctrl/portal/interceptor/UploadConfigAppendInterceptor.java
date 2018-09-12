package com.qtrmoon.zygl.ctrl.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/***
 * 上传配置信息追加拦截器
 */
@Service
public class UploadConfigAppendInterceptor extends HandlerInterceptorAdapter {
	
	@Value("${fileServer}")
	private String fileServer; // 文件上传服务器

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		try{
			request.setAttribute("fileServer", fileServer);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
}
