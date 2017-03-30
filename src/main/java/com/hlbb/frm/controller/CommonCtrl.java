package com.hlbb.frm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/common")
public class CommonCtrl {
	@PostMapping("/upload")
	public void upload(MultipartFile file){
		
	}
}
