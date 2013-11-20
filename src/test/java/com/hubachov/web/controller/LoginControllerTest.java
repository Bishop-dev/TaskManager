package com.hubachov.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LoginControllerTest {
	private MockMvc mockMvc;

	private static final String PATH__PREFIX = "/WEB-INF/pages/";
	private static final String PATH__SUFFIX = ".jsp";
	private static final String PATH__REQUEST_INDEX = "/";
	private static final String PATH__REQUEST_LOGIN_PAGE = "/login";
	private static final String PATH__REQUEST_LOGIN_FAIL = "/login-fail";
	private static final String PATH__REQUEST_LOGOUT = "/logout";
	private static final String PATH__REQUEST_REGISTRATION = "/registration";
	private static final String PATH__LOGIN = "login";
	private static final String PATH__ADMIN_HOME = "admin/cabinet";
	private static final String PATH__USER_HOME = "user/index";
	private static final String PATH__REDIRECT = "redirect:";
	private static final String PATH__REGISTRATION = "registration";

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(LoginController.class).setViewResolvers(viewResolver()).build();
	}

	@Test
	public void testGetLoginPage() {
		try {
			mockMvc.perform(get(PATH__REQUEST_INDEX)).andExpect(status().isOk()).andExpect(view().name(PATH__LOGIN)).
					andExpect(forwardedUrl(PATH__PREFIX + PATH__LOGIN + PATH__SUFFIX));
			mockMvc.perform(get(PATH__REQUEST_LOGIN_PAGE)).andExpect(status().isOk()).andExpect(view().name(PATH__LOGIN)).
					andExpect(forwardedUrl(PATH__PREFIX + PATH__LOGIN + PATH__SUFFIX));
		} catch (Exception e) {
			fail("Can't connect to servlet");
		}
	}

	private static ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix(PATH__PREFIX);
		viewResolver.setSuffix(PATH__SUFFIX);
		return viewResolver;
	}
}
