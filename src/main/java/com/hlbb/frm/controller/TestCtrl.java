package com.hlbb.frm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 控制器示例
 * 所有请求不要加 try catch。处理逻辑都交由service，
 * 如有异常发生或自定义异常类 抛出对应的exception类 交由全局Handler处理
 */
@RestController
@RequestMapping("/test")
public class TestCtrl {

    private final static Logger log = LoggerFactory.getLogger(TestCtrl.class);


}
