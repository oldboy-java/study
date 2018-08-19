package com.sky.sell.common.utils.jpa.sort;

import org.springframework.data.domain.Sort;

/***
 * 排序对象
 * @author	刘力
 * @date	2017年12月2日下午3:09:20
 * @version 1.0
 */
public class SortDto {

    //排序方式
    private String orderType;

    //排序字段
    private String orderField;

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public SortDto(String orderType, String orderField) {
        this.orderType = orderType;
        this.orderField = orderField;
    }

    //默认为DESC排序
    public SortDto(String orderField) {
        this.orderField = orderField;
        this.orderType = Sort.DEFAULT_DIRECTION.name();
    }
}
