package com.zed.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zed.demo.threadLocal.RequestHolder;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
	    log.info("preHandle");
	    return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		RequestHolder.remove();
		log.info("afterHandele");
	}

	
}
