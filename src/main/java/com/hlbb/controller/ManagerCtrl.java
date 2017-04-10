package com.hlbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hlbb.frm.config.Result;
import com.hlbb.module.manager.Manager;
import com.hlbb.module.manager.ManagerDao;
import com.hlbb.module.manager.ManagerService;

@RestController
@RequestMapping("/mng")
public class ManagerCtrl {
	
	@Autowired
	private ManagerDao managerDao;
	@Autowired
	private ManagerService managerService;
	
	@GetMapping("/getManagerById")
	public Manager getManagerById(Long id){
		return managerDao.findById(id);
	}
	
	@GetMapping("/login")
	public Manager login(String userName,String password){
		return managerService.login(userName, password);
	}
	
	@PostMapping
	public void register(String loginName,String code,String password,String surepwd){
		managerService.register(loginName,code,password,surepwd);
	}
}
