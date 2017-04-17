package com.hlbb.frm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hlbb.frm.interceptor.SignInterceptor;

/**
 * Created by Rui.Zhou on 2017/3/20.
 * 配置全局拦截器
 */
@Configuration
public class AppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加签名算法拦截器 给app使用
        SignInterceptor signInterceptor = new SignInterceptor();

        InterceptorRegistration signIR = registry.addInterceptor(signInterceptor);
        signIR.addPathPatterns("/api/**");
        
        super.addInterceptors(registry);
    }
}
