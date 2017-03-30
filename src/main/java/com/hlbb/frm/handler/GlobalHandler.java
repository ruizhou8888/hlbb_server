package com.hlbb.frm.handler;

import com.hlbb.frm.config.Result;
import com.hlbb.frm.exception.GlobalException;
import com.hlbb.frm.kit.ResultKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rui.Zhou on 2017/3/20.
 */
@ControllerAdvice
public class GlobalHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalHandler.class);

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        //统一获取异常并抓取处理。如果是自定义异常 则抛出对应的异常enum
        if(e instanceof GlobalException){
            GlobalException globalException = (GlobalException) e;
            logger.error("【自定义异常】{}",e.getMessage());
            return ResultKit.error(globalException.getCode(),globalException.getMessage());
        }else{
            logger.error("【系统异常】{}",e);
            return ResultKit.error(-1,"未知错误");
        }
    }
}
