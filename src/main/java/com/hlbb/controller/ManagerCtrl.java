package com.hlbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hlbb.frm.config.Result;
import com.hlbb.frm.kit.ResultKit;
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
	public Result getManagerById(Long id){
		return ResultKit.success(managerDao.findOne(id));
	}
	
	@GetMapping("/login")
	public Result login(String userName,String password){
		return ResultKit.success(managerService.login(userName, password));
	}
	
	@PostMapping("/register")
	public Result register(String loginName,String password,String checkCode,String surepwd){
		return ResultKit.success(managerService.register(loginName, password,surepwd,checkCode));
	}

}
