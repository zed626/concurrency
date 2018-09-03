package com.zed.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.zed.demo.threadLocal.RequestHolder;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class HttpFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request2=(HttpServletRequest)request;
		log.info("do filter,{},{}",Thread.currentThread().getId(),request.getServletContext());
		RequestHolder.add(Thread.currentThread().getId());
		chain.doFilter(request2, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
