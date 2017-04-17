package com.hlbb.controller;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hlbb.frm.config.Result;
import com.hlbb.frm.kit.ResultKit;
import com.hlbb.module.company.Company;
import com.hlbb.module.company.CompanyService;


@RestController
@RequestMapping("company")
public class CompanyCtrl {
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/perfect")
	public Result perfect(Company company,@RequestParam("mngId")String mngId) throws FileNotFoundException{
		return ResultKit.success(companyService.perfect(company,mngId));
	}
	
	@GetMapping("/getCompanyInfo")
	public Result perfect(String mngId) throws FileNotFoundException{
		return ResultKit.success(companyService.getCompanyByMngId(mngId));
	}
	
	@InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    } 
}
