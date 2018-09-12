package com.qtrmoon.common;

import javax.servlet.http.HttpSession;

import com.qtrmoon.sysmanage.pojo.User;

public class SessionUtil {
	
	private static final String PORTAL_SESSION_USER = "PORTAL_SESSION_USER"; //门户用户
	
	/**
	 * 设置用户Session
	 * @param session
	 * @param user
	 * @param sessionName
	 */
	public static void  addPortalSessionUser(HttpSession session,User user,String sessionName){
		session.setAttribute(sessionName, user);
	}
	
	/**
	 * 获取用户Session
	 * @param session
	 * @param sessionName
	 * @return
	 */
	public static User getSessionUser(HttpSession session,String sessionName){
		return session.getAttribute(sessionName) == null ? null:(User)session.getAttribute(sessionName);
	}
	
	/***
	 * 删除用户Session
	 * @param session
	 * @param sessionName
	 */
	public static void removeSessionUser(HttpSession session,String sessionName){
		session.removeAttribute(sessionName);
	}
	
	/***
	 * 获取PortalSessionUser
	 * @return
	 */
	public static String getPortalSessionUser() {
		return PORTAL_SESSION_USER;
	}
	
}
