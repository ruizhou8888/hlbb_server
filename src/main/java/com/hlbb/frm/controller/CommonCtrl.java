package com.hlbb.frm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hlbb.frm.config.Result;
import com.hlbb.frm.enums.ResultEnum;
import com.hlbb.frm.kit.MailKit;
import com.hlbb.frm.kit.RandomKit;
import com.hlbb.frm.kit.ResultKit;

@RestController
@RequestMapping("/common")
public class CommonCtrl {

	private final static Logger log = LoggerFactory.getLogger(CommonCtrl.class);
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	private String nowDay = sdf.format(new Date());
	private String basePath ="E:/upload/files/" + nowDay + "/";
	
	@Autowired
	private MailKit mailKit;
	
	@PostMapping("/upload")
	public Result upload(@RequestParam("file")MultipartFile file){
		File uploadSource = new File(basePath);
		if(!uploadSource.exists()){
			uploadSource.mkdirs();
		}
		if(!file.isEmpty()){
           String fileName = "";
		   try {
        	  String oldName = file.getOriginalFilename();
        	  String suffix = oldName.substring(oldName.lastIndexOf("."));
        	  fileName = RandomKit.randomStr()+suffix;
        	  String uploadPath = basePath + fileName;
              BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(uploadPath)));
              out.write(file.getBytes());
              out.flush();
              out.close();
           } catch (FileNotFoundException e) {
        	   log.error("上传文件失败",e.getMessage());
        	   return ResultKit.error(ResultEnum.UPLOAD_ERROR);
           } catch (IOException e) {
        	   log.error("上传文件失败",e.getMessage());
        	   return ResultKit.error(ResultEnum.UPLOAD_ERROR);
           }
           return ResultKit.success("files/"+nowDay+"/"+fileName);
       }else{
    	   log.error("上传文件失败","上传的文件为空");
    	   return ResultKit.error(ResultEnum.UPLOAD_ERROR);
       }
	}

	@PostMapping("/getEmailCode")
	public Result getEmailCode(String email){
		mailKit.sendEmailCode(email);
		return ResultKit.success();
	}
}
