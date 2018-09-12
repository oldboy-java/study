package com.qtrmoon.common;

/***
 * 分页大小常量
 *
 */
public enum PageSizeEnum {
	
	RECOMMEND_PAGESIZE_INDEX(8), //首页推荐资源
	RECOMMEND_PAGESIZE(8),//推荐资源显示条数
	SEARCH_PAGESIZE(6), //搜索页每页显示条数
	RELATED__PAGESIZE(4), //相关资源
	FOLLOWED_PAGESIZE(7); //大家关注的
	
	private Integer count; //数量

	private PageSizeEnum(Integer count) {
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
