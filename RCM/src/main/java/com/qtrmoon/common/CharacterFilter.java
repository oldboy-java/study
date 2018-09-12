package com.qtrmoon.common;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.qtrmoon.dictionary.bsd.DBUtil;

@WebFilter(filterName="myfilter",urlPatterns="/*")  
public class CharacterFilter implements Filter {
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("projectName", Constant.PRONAME);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String projectName=arg0.getServletContext().getContextPath();
		projectName=projectName.replace("/", "");
		Constant.PRONAME=projectName;
		Constant.createConstant();
		new DBUtil().initDefault("jdbc.properties");
	}

}
