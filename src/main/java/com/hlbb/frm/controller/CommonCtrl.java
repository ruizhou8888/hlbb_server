package com.hlbb.frm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hlbb.frm.config.Result;
import com.hlbb.frm.kit.MailKit;
import com.hlbb.frm.kit.ResultKit;

@RestController
@RequestMapping("/common")
public class CommonCtrl {
	
	@Autowired
	private MailKit mailKit;
	
	@PostMapping("/upload")
	public void upload(MultipartFile file){
		
	}
	
	@PostMapping("/getEmailCode")
	public Result getEmailCode(String email){
		mailKit.sendEmailCode(email);
		return ResultKit.success();
	}
}
