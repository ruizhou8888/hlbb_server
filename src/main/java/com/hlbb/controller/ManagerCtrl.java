package com.hlbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hlbb.module.manager.Manager;
import com.hlbb.module.manager.ManagerDao;

@RestController
@RequestMapping("/mng")
public class ManagerCtrl {
	
	@Autowired
	private ManagerDao managerDao;
	
	@GetMapping("/getManagerById")
	public Manager getManagerById(Long id){
		return managerDao.findById(id);
	}
}
