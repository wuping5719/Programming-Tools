package com.nick.love.myra;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyraFilter implements Filter {
   @Override
   public void doFilter(ServletRequest request, ServletResponse response, 
		   FilterChain filterChain) throws IOException, ServletException {
	   System.out.println(getClass().getName() + ".doFilter");
	   filterChain.doFilter(request, response);
   }
   
   @Override 
   public void init(FilterConfig filterConfig) throws ServletException {
	   System.out.println("I love Myra Ma.");
   }
   
   @Override 
   public void destroy() { 
	   System.out.println("Nick's Girl : Myra Ma.");
   }
}
