package com.hlbb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hlbb.frm.config.Result;
import com.hlbb.frm.kit.ResultKit;
import com.hlbb.module.notice.NoticeService;

@RestController
@RequestMapping("notice")
public class NoticeCtrl {
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("getNotices")
	public Result getNotices(@RequestParam Map<String,String> map){
		return ResultKit.success(noticeService.getNotices(map));
	}
	
	@GetMapping("getNoticeByCompany")
	public Result getNoticeByCompany(@RequestParam Map<String,String> map){
		return ResultKit.success(noticeService.getNoticeByCompany(map));
	}
	
	@PostMapping("saveNotice")
	public Result saveNotice(@RequestParam Map<String,String> map){
		noticeService.saveNotice(map);
		return ResultKit.success();
	}
	
	@PostMapping("delNotice")
	public Result delNotice(String ids){
		noticeService.deleteNotice(ids);
		return ResultKit.success();
	}
}
