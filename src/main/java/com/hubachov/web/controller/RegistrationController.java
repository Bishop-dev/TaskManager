package com.hubachov.web.controller;

import com.hubachov.dataaccess.service.RoleService;
import com.hubachov.dataaccess.service.UserService;
import com.hubachov.entity.User;
import com.hubachov.form.bean.UserForm;
import com.hubachov.form.validator.UserFormValidator;
import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class RegistrationController {
	private static final Logger LOG = Logger.getLogger(RegistrationController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ReCaptcha reCaptcha;

	private static final String PATH__REGISTRATION_PAGE = "registration";
	private static final String PATH__REDIRECT = "redirect:";
	private static final String PATH__LOGIN = "login";
	private static final String LABEL__MESSAGE = "message";
	private static final String ATTRIBUTE_NAME = "userForm";
	private static final String MESSAGE__WRONG_CAPTCHA = "Wrong login/password";
	private static final String MESSAGE__WRONG_USER_DATA = "Wrong registration data";
	private static final String MESSAGE__INTERNAL_SERVICE_ERROR = "Internal error. Try again.";
	private static final String MESSAGE__LOGIN_BUSY = "Login busy. Try another one.";
	private static final String MESSAGE__REGISTRATION_COMPLETE = "You may enter using your login and password.";

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegistrationPage(Model model) {
		model.addAttribute("userForm", new UserForm());
		return PATH__REGISTRATION_PAGE;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("UserForm") UserForm userForm,
						   BindingResult result, HttpServletRequest request, Model model,
						   @RequestParam("recaptcha_challenge_field") String challangeField,
						   @RequestParam("recaptcha_response_field") String responseField,
						   RedirectAttributes attributes, HttpServletResponse response) throws IOException {
		// check captcha
		String remoteAddress = request.getRemoteAddr();
		ReCaptchaResponse reCaptchaResponse = this.reCaptcha.checkAnswer(
				remoteAddress, challangeField, responseField);
		if (!reCaptchaResponse.isValid()) {
			model.addAttribute(LABEL__MESSAGE, MESSAGE__WRONG_CAPTCHA);
			model.addAttribute(ATTRIBUTE_NAME, userForm);
			LOG.info(MESSAGE__WRONG_CAPTCHA);
			return PATH__REGISTRATION_PAGE;
		}
		// validate form
		new UserFormValidator().validate(userForm, result);
		if (result.hasErrors()) {
			model.addAttribute(LABEL__MESSAGE, MESSAGE__WRONG_USER_DATA);
			model.addAttribute(ATTRIBUTE_NAME, userForm);
			LOG.warn(MESSAGE__WRONG_USER_DATA);
			return PATH__REGISTRATION_PAGE;
		}
		// check login
		String login = userForm.getLogin();
		User user = null;
		try {
			user = userService.getUserByLogin(login);
		} catch (Exception e) {
			model.addAttribute(LABEL__MESSAGE, MESSAGE__INTERNAL_SERVICE_ERROR);
			model.addAttribute(ATTRIBUTE_NAME, userForm);
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			LOG.error("Can't check login " + login, e);
			return PATH__REGISTRATION_PAGE;
		}
		if (user != null) {
			model.addAttribute(LABEL__MESSAGE, MESSAGE__LOGIN_BUSY);
			model.addAttribute(ATTRIBUTE_NAME, userForm);
			LOG.warn("Can't check login " + login);
			return PATH__REGISTRATION_PAGE;
		}
		// if OK
		try {
			userService.createUser(createUser(userForm));
		} catch (Exception e) {
			LOG.error("Can't save new user " + userForm.getLogin(), e);
			model.addAttribute(LABEL__MESSAGE, MESSAGE__INTERNAL_SERVICE_ERROR);
			model.addAttribute(ATTRIBUTE_NAME, userForm);
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return PATH__REGISTRATION_PAGE;
		}
		attributes.addFlashAttribute(LABEL__MESSAGE, MESSAGE__REGISTRATION_COMPLETE);
		return PATH__REDIRECT + PATH__LOGIN;
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
	public boolean checkLogin() {
		return false;
	}

	private User createUser(UserForm form) throws Exception {
		return null;
	}
}
