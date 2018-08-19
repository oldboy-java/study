package com.liuli.sm.vo;

import com.liuli.sm.pojo.User;
import com.liuli.sm.util.Page;

public class UserQueryVo extends User {

	Page<User> page = new Page<User>();

	public Page<User> getPage() {
		return page;
	}

	public void setPage(Page<User> page) {
		this.page = page;
	}
	
}
