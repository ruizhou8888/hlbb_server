package com.hlbb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
import com.hlbb.module.wall.CompanyWall;
import com.hlbb.module.wall.WallService;

@RestController
@RequestMapping("wall")
public class WallCtrl {
	@Autowired
	private WallService wallService;
	
	@GetMapping("/getWalls")
	public Result getWalls(@RequestParam Map<String,String> paramMap){
		return ResultKit.success(wallService.getWalls(paramMap));
	}

    @GetMapping("/getWallById")
    public Result getWallById(String id){
        return ResultKit.success(wallService.getWallById(id));
    }
	
	@PostMapping("/saveWall")
	public Result saveWall(CompanyWall wall){
		return ResultKit.success(wallService.saveWall(wall));
	}


    @PostMapping("/sendReview")
    public Result sendReview(CompanyWall wall){
        wall.setState(1l);
        wall.setStateNote("正在审核中...");
        return ResultKit.success(wallService.saveWall(wall));
    }

	@InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    }
}
