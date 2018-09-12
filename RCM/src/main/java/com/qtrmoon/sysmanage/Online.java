package com.qtrmoon.sysmanage;

import java.util.HashMap;
import java.util.Map;

import com.qtrmoon.sysmanage.pojo.User;

public class Online {
	private static Map<String, User> onlineUser = new HashMap<String, User>();// 在线用户

	public static Map<String, User> getOnlineUser() {
		return onlineUser;
	}

	public static void addUser(User user) {
		if (onlineUser.get(user.getId())== null) {
			onlineUser.put(user.getId().toString(),user);
		}
	}

	public static void delUser(String id) {
		onlineUser.remove(id);
	}
}
