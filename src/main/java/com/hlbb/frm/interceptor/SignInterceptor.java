package com.hlbb.frm.interceptor;

import com.hlbb.frm.enums.ResultEnum;
import com.hlbb.frm.exception.GlobalException;
import com.hlbb.frm.kit.HashKit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Rui.Zhou on 2017/3/20.
 * app请求签名拦截器
 */
public class SignInterceptor implements HandlerInterceptor {

    @Value("${appId}")
    private String appId;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String userId=request.getParameter("userId");
        String deviceToken = request.getParameter("deviceToken");
        String timestamp = request.getParameter("timestamp");
        String sign = request.getParameter("sign");
        if(null==sign || sign.equals("") || null==userId || userId.equals("") || null==deviceToken ||
                deviceToken.equals("") || null==timestamp || timestamp.equals("")){
            throw new GlobalException(ResultEnum.SIGN_PARAM_ERROR);
        }
        StringBuilder sb = new StringBuilder("userId="+userId+"&deviceToken="+deviceToken+"&timestamp="+timestamp+"&appId="+appId);
        if(HashKit.md5(sb.toString()).equals(sign)){
            //比较签名参数
            throw new GlobalException(ResultEnum.SIGN_ERROR);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
