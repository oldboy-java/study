package com.sky.sell.common.utils.jpa.sort;

import org.springframework.data.domain.Sort;

import com.sky.sell.common.enums.SortEnum;

/**
 * 排序工具类
 * @author	刘力
 * @date	2017年12月2日下午3:13:43
 * @version 1.0
 */
public class SortUtils {

	public static Sort basicSort() {
        return basicSort(SortEnum.DESC.getOrder(), "id");
    }

    public static Sort basicSort(String orderType, String orderField) {
        Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
        return sort;
    }

	/**
     * 批量构造排序对象
     * @param dtos
     * @return
     */
    public static Sort basicSort(SortDto... dtos) {
        Sort result = null;
        for(int i=0; i<dtos.length; i++) {
            SortDto dto = dtos[i];
            if(result == null) {
                result = new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField());
            } else {
                result = result.and(new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField()));
            }
        }
        return result;
    }
}
