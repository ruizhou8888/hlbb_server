package com.hlbb.controller;

import java.io.FileNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hlbb.module.company.Company;

@RestController
@RequestMapping("company")
public class CompanyCtrl {
	
	@PostMapping("/perfect")
	public void perfect(Company company) throws FileNotFoundException{
		
	}
}
