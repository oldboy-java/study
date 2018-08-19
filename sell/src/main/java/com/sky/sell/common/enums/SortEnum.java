package com.sky.sell.common.enums;

import lombok.Getter;

@Getter
public enum SortEnum {

	DESC("desc"),ASC("asc");
	
	String order;

	private SortEnum(String order) {
		this.order = order;
	}
}
