package com.qtrmoon.sysmanage;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qtrmoon.common.Constant;
import com.qtrmoon.sysmanage.pojo.Function;
import com.qtrmoon.sysmanage.pojo.Role;
import com.qtrmoon.sysmanage.pojo.User;

@WebFilter(filterName="userRightValidateFilter",urlPatterns="/*")
public class UserRightValidateFilter implements Filter {
	private final String[] letitgo=new String[]{
		"/",
		"/dict",
		"/common/error_illegal.jsp",
		"/common/error_timeout.jsp",
		"/common/error.jsp",
		"/sysmanage/login/login.action",
		"/sysmanage/login/logout.action"
	};

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest) request;
		String myforward = hsr.getRequestURI();
		myforward = fmtPath(myforward);
		if (letitgo(myforward)) {//放过绿色地址
			chain.doFilter(request, response);
			return;
		}
		
		// 判断用户是否登陆，放过一些非法提示页。
		User userForm=(User)((HttpServletRequest)request).getSession().getAttribute(SysConstant.CURRENT_USER);
		//判断用户权限
		List<Function> functionList = userForm.getMenu();
		String link,moban;
		Pattern p;
		Matcher m;
		for (Function fun:functionList) {
			link = fun.getLink();
			if (link != null && !link.equals("")) {
				moban = link.replaceAll("\\?", "_");
				p = Pattern.compile(moban);
				m = p.matcher(myforward);
				if (m.matches()) {
					chain.doFilter(request, response);
					return;
				}
			}
		}
//		((HttpServletResponse)response).sendRedirect("/"+Constant.PRONAME+"/common/error_illegal.jsp");
		chain.doFilter(request, response);
	}

	/**
	 * 检测绿色权限，是则返回true。
	 * @param url
	 * @return
	 */
	private boolean letitgo(String url) {
		for(String path:letitgo){
			if(path.length()<2&&url.length()<2){
				return url.equals(path);
			}else if(url.indexOf(path)>=0){
				return true;
			}
		}
		return false;
	}

	/**
	 * 格式化路径，去掉工程名，去掉重复"/"。
	 * @param myforward
	 * @return
	 */
	private String fmtPath(String myforward) {
		myforward = myforward.substring(myforward.indexOf("/"+Constant.PRONAME+"/")+Constant.PRONAME.length()+1);
		myforward = myforward.replaceAll("//", "/");
		return myforward;
	}

	public void init(FilterConfig config) throws ServletException {
	}

}
