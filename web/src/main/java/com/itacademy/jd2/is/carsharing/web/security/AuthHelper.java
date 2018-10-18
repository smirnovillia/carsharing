package com.itacademy.jd2.is.carsharing.web.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthHelper {
	
	private AuthHelper() {
	}

	public static Integer getLoggedUserId() {
		SecurityContext context = SecurityContextHolder.getContext();
		ExtendedUsernamePasswordAuthenticationToken authentication = (ExtendedUsernamePasswordAuthenticationToken) context
				.getAuthentication();
		return authentication.getId();
	}
}
