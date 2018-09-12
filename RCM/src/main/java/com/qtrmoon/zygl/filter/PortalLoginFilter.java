package com.qtrmoon.zygl.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qtrmoon.common.SessionUtil;
import com.qtrmoon.sysmanage.pojo.User;


/**
 * Servlet Filter implementation class PortalLoginFilter
 */
public class PortalLoginFilter implements Filter {

	private String LOGIN_VALIDATE_URLS_PREFIX;
	private String LOGIN_VALIDATE_IGNORE_URLs;
	
    /**
     * Default constructor. 
     */
    public PortalLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String url = req.getRequestURI();
		
		if(!url.endsWith(".js") && !url.endsWith(".css") && !url.endsWith(".jpg") && !url.endsWith(".png") && !url.endsWith(".jsp")){
			if(url.contains(LOGIN_VALIDATE_URLS_PREFIX)){
				List<String> igoreUrls = Arrays.asList(LOGIN_VALIDATE_IGNORE_URLs.split(","));
				url = url.substring(url.lastIndexOf(com.qtrmoon.common.Constant.PRONAME)+com.qtrmoon.common.Constant.PRONAME.length());
				if(!igoreUrls.contains(url)) {
					HttpSession session = req.getSession();
					User user = (User) session.getAttribute(SessionUtil.getPortalSessionUser());
					if(user==null) {
						resp.sendRedirect("/"+com.qtrmoon.common.Constant.PRONAME+"/portal/index.action");
					}else {
						chain.doFilter(request, response);
					}
				}else{
					chain.doFilter(request, response);
				}
			}else{
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		}else {
			chain.doFilter(request, response);
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOGIN_VALIDATE_URLS_PREFIX = fConfig.getInitParameter("LOGIN_VALIDATE_URLS_PREFIX");
		LOGIN_VALIDATE_IGNORE_URLs = fConfig.getInitParameter("LOGIN_VALIDATE_IGNORE_URLs");
	}

}
