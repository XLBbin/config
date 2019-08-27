package com.tedu.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class CookieUtil {
	
	public static void setCookie(HttpServletResponse response,String name
			,String value,String domain,String path,int maxAge) {
		
		Cookie cookie = new Cookie(name, value);
		if (!StringUtils.isEmpty(domain)) {
			cookie.setDomain(domain);
		}
		cookie.setMaxAge(maxAge);
		cookie.setPath(path);
		response.addCookie(cookie);
	}
	
	public static void setCookie(HttpServletResponse response,String name) {
		setCookie(response, name, "", null,"/", 3600);
	}
	
	public static void setCookie(HttpServletResponse response,String name,String value) {
		setCookie(response, name, value, null,"/", 3600);
	}
	
	public static void setCookie(HttpServletResponse response,String name
			,String value,int maxAge) {
		setCookie(response, name, value, null,"/", maxAge);
	}
	
	public static String getCookie(HttpServletRequest request, String name) {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					value = cookie.getValue();
				}
			}
		}
		return value;
	}

	public static void removeCookie(HttpServletResponse response, String name, String domain, String path) {
		setCookie(response, name, "", domain, path, 0);
	}
}
