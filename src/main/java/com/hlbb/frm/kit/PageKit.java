package com.hlbb.frm.kit;

import java.util.Map;

import org.springframework.data.domain.PageRequest;

public class PageKit {
	public static PageRequest buildPageRequest(Map<String,String> paramMap) {
        int page=1;int pageSize = 15;
        String pageNum = paramMap.get("page");
        String size = paramMap.get("pageSize");
        if(!StrKit.isBlank(pageNum)){
        	page = Integer.valueOf(pageNum);
        }
        if(!StrKit.isBlank(size)){
        	pageSize = Integer.valueOf(size);
        }
        
        return new PageRequest(page - 1, pageSize, null);
    }
}
