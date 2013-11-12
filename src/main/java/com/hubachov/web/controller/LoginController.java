package com.hubachov.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class LoginController {
	private static final String PATH__LOGIN_PAGE = "login";

	private static final String LABEL__MESSAGE = "message";

	private static final String MESSAGE__LOGIN_FAIL = "Wrong login/password";

	@RequestMapping(value = {"/", "index", "login"}, method = RequestMethod.GET)
	public String login() {
		return PATH__LOGIN_PAGE;
	}

	@RequestMapping(value = "login-fail", method = RequestMethod.GET)
	public String loginFail(Map<String, Object> map) {
		map.put(LABEL__MESSAGE, MESSAGE__LOGIN_FAIL);
		return PATH__LOGIN_PAGE;
	}
}
