package com.itsone.igm.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class MyServletUtil {
	
	public static HttpSession getSession(){
		return (HttpSession)RequestContextHolder.currentRequestAttributes().resolveReference(RequestAttributes.REFERENCE_SESSION);
	}
	
	public static HttpServletRequest getRequest(){
		return (HttpServletRequest)RequestContextHolder.currentRequestAttributes().resolveReference(RequestAttributes.REFERENCE_REQUEST);
	}
	
	public static Object getLoginInfo() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object loginInfo = auth.getDetails();
		
		return loginInfo;
	}
}
