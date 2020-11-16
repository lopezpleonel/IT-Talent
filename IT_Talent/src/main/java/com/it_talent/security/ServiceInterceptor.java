package com.it_talent.security;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ServiceInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

		Date created = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String creationDate = sdf.format(created);
		
		System.out.println("===========================================================================");
		System.out.println(creationDate);
		System.out.println("URI: " + request.getRequestURI());
		System.out.println("Method: " + request.getMethod());
		System.out.println("Status: " + response.getStatus());		
		System.out.println("Produces: " + response.getContentType());
		System.out.println("===========================================================================");
	}

}
