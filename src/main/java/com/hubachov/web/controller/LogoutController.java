package com.hubachov.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {
	private static final String PATH__REDIRECT = "redirect:";
	private static final String PATH__LOGIN_PAGE = "login";

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return PATH__REDIRECT + PATH__LOGIN_PAGE;
	}
}
