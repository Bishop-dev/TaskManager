package com.hubachov.web.controller;

import com.hubachov.dataaccess.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

@Controller
public class LoginController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	@Autowired
	private UserService userService;
	private static final String PATH__LOGIN_PAGE = "login";
	private static final String PATH__INDEX_PAGE = "index";

	private static final String LABEL__MESSAGE = "message";

	private static final String MESSAGE__LOGIN_FAIL = "Wrong login/password";
	private static final String MESSAGE__SERVER_ERROR = "Error happened. Try again.";

	private static final String LOG_MESSAGE__USER_NOT_FOUND = "Can't find user and set it to session";

	private static final String SESSION_ATTRIBUTE_NAME__USER = "user";

	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String login() {
		return PATH__LOGIN_PAGE;
	}

	@RequestMapping(value = "login-fail", method = RequestMethod.GET)
	public String loginFail(Map<String, Object> map) {
		map.put(LABEL__MESSAGE, MESSAGE__LOGIN_FAIL);
		return PATH__LOGIN_PAGE;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Principal principal, Map<String, Object> map) {
		String login = principal.getName();
		if (login != null) {
			try {
				request.getSession().setAttribute(SESSION_ATTRIBUTE_NAME__USER, userService.getUserByLogin(login));
			} catch (Exception e) {
				log.error(LOG_MESSAGE__USER_NOT_FOUND, e);
				map.put(LABEL__MESSAGE, MESSAGE__SERVER_ERROR);
				return PATH__LOGIN_PAGE;
			}
		}
		if (request.isUserInRole("admin")) {
			return PATH__INDEX_PAGE;
		}
		if (request.isUserInRole("user")) {
			return PATH__INDEX_PAGE;
		}
		return PATH__LOGIN_PAGE;
	}
}
