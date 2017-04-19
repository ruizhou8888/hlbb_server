package com.hlbb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.hlbb.frm.config.Result;
import com.hlbb.frm.kit.ResultKit;
import com.hlbb.module.constant.ConstantService;
import com.hlbb.module.constant.ConstantType;

@RestController
@RequestMapping("constant")
public class ConstantCtrl {
	@Autowired
	private ConstantService constantService;
	
	@GetMapping("/getConstantType")
	public Result getConstantType(@RequestParam Map<String,String> map){
		return ResultKit.success(constantService.findConstantTypeAll(map));
	}
	
	@GetMapping("/findConstantByTypeNo")
	public Result getConstant(@RequestParam Map<String,String> map){
		return ResultKit.success(constantService.findConstantByTypeNo(map));
	}
	
	@PostMapping("/delConstantType")
	public Result delConstantType(String ids){
		List<ConstantType> cts = JSONObject.parseArray(ids, ConstantType.class);
		constantService.delConstantType(cts);
		return ResultKit.success();
	}
}
