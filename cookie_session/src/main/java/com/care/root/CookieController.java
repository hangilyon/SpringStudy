package com.care.root;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	@GetMapping("cookie")
	public String myCookie(HttpServletResponse response,
						HttpServletRequest request,
						@CookieValue(value="myCookie", required = false ) Cookie cookie) {
		
		// 다른 데서 만든 쿠키도 다 가지고 와서 비효율적
		//for(Cookie c : request.getCookies()) {
		//	System.out.println(c.getName());
		//}

		return "cook/cookie";
	}
	@RequestMapping("popup")
	public String popup() {
		return "cook/popup";
	}
	@RequestMapping("MakeCookie")
	public void MakeCookie(HttpServletResponse response) {
		Cookie cook = new Cookie("myCookie","cnt10s");
		cook.setMaxAge(10);
		response.addCookie(cook);
	}
}
