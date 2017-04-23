package com.hlbb.module.notice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hlbb.frm.kit.PageKit;
import com.hlbb.frm.kit.StrKit;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private NoticeCompanyDao noticeCompanyDao;
	
	/**
	 * 获取所有通知
	 */
	public Page<Notice> getNotices(Map<String,String> map){
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(Direction.DESC,"createdTime"));
		Page<Notice> notices = noticeDao.findAll(PageKit.buildPageRequest(map,orders));
		return notices;
	}
	/**
	 * 公司获取收到的通知
	 * @return
	 */
	public List<Notice> getNoticeByCompany(Map<String,String> map){
		String companyId = map.get("companyId").toString();
		List<Notice> notices = noticeDao.findByCompany(Long.valueOf(companyId));
		return notices;
	}
	
	@Transactional
	public void saveNotice(Map<String, String> map) {
		String title = map.get("title");
		String content = map.get("content");
		String sendType = map.get("sendType");
		Notice notice = new Notice(title,content,sendType);
		if(!StrKit.isBlank(map.get("id").toString())){
			notice.setId(Long.valueOf(map.get("id").toString()));
		}
		noticeDao.save(notice);
		if(sendType.equals("1")){
			String ids = map.get("companyIds");
			JSONArray cids = JSONObject.parseArray(ids);
			cids.forEach((co)->{
				Long  companyId = Long.valueOf(co.toString());
				NoticeCompany nc = new NoticeCompany(notice.getId(),companyId);
				noticeCompanyDao.save(nc);
			});			
		}
	}
	
	@Transactional
	public void deleteNotice(String ids){
		JSONArray nids = JSONObject.parseArray(ids);
		nids.forEach((co)->{
			Long  id = Long.valueOf(co.toString());
			noticeCompanyDao.deleteByNoticeId(id);
			noticeDao.delete(id);
		});
	}
}
