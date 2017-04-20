package com.hlbb.frm.kit;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

public class PageKit {
	public static PageRequest buildPageRequest(Map<String,String> paramMap,List<Order> orders) {
        int page=1;int pageSize = 15;
        String pageNum = paramMap.get("page");
        String size = paramMap.get("pageSize");
        if(!StrKit.isBlank(pageNum)){
        	page = Integer.valueOf(pageNum);
        }
        if(!StrKit.isBlank(size)){
        	pageSize = Integer.valueOf(size);
        }
        if(orders!=null && !orders.isEmpty()){
        	return new PageRequest(page - 1, pageSize, new Sort(orders));
        }else{
        	return new PageRequest(page - 1, pageSize, null);        	
        }
    }
	
	public static PageRequest buildPageRequest(Map<String,String> paramMap) {
		return buildPageRequest(paramMap,null);
	}
}
