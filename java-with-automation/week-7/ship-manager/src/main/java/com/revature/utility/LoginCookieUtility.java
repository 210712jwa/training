package com.revature.utility;

import javax.servlet.http.HttpServletResponse;

public class LoginCookieUtility {
	
	private LoginCookieUtility() {
	}
	
	public static void modifyCookieInfo(HttpServletResponse resp) {
		String setCookieHeader = resp.getHeader("Set-Cookie");
		
		setCookieHeader = setCookieHeader + "; SameSite=None";
		resp.setHeader("Set-Cookie", setCookieHeader);
	}

}
