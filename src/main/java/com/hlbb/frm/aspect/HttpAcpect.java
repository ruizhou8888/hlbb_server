package com.hlbb.frm.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAcpect {
	private final static Logger logger = LoggerFactory.getLogger(HttpAcpect.class);
	
	@Pointcut("execution(public * com.hlbb.controller.*.*(..))")
	public void log(){
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		logger.info("URL： " + request.getRequestURL());
		logger.info("Method： "+request.getMethod());
		logger.info("IP： "+request.getRemoteAddr());
		logger.info("Action： "+joinPoint.getSignature().getDeclaringTypeName()+" => "+joinPoint.getSignature().getName());
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("args： "+args.substring(1,args.length()-1));
	}
	
	@After("log()")
	public void doAfter(){
		
	}
}
