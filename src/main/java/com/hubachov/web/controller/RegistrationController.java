package com.hubachov.web.controller;

import com.hubachov.dataaccess.service.RoleService;
import com.hubachov.dataaccess.service.UserService;
import com.hubachov.entity.Role;
import com.hubachov.entity.User;
import com.hubachov.entity.UserStatus;
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
import java.util.Date;

@Service
public class RegistrationController {
    private static final Logger LOG = Logger.getLogger(RegistrationController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ReCaptcha reCaptcha;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return PathHolder.PATH__REGISTRATION_PAGE;
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
            model.addAttribute(PathHolder.ATTRIBUTE_NAME__MESSAGE, PathHolder.MESSAGE__WRONG_CAPTCHA);
            model.addAttribute(PathHolder.ATTRIBUTE_NAME__USERFORM, userForm);
            LOG.info(PathHolder.MESSAGE__WRONG_CAPTCHA);
            return PathHolder.PATH__REGISTRATION_PAGE;
        }
        // validate form
        new UserFormValidator().validate(userForm, result);
        if (result.hasErrors()) {
            model.addAttribute(PathHolder.ATTRIBUTE_NAME__MESSAGE, PathHolder.MESSAGE__WRONG_USER_DATA);
            model.addAttribute(PathHolder.ATTRIBUTE_NAME__USERFORM, userForm);
            LOG.warn(PathHolder.MESSAGE__WRONG_USER_DATA);
            return PathHolder.PATH__REGISTRATION_PAGE;
        }
        // check login
        String login = userForm.getLogin();
        try {
            if (!userService.checkLogin(userForm.getLogin())) {
                model.addAttribute(PathHolder.ATTRIBUTE_NAME__MESSAGE, PathHolder.MESSAGE__LOGIN_BUSY);
                model.addAttribute(PathHolder.ATTRIBUTE_NAME__USERFORM, userForm);
                LOG.warn("Can't check login " + login);
                return PathHolder.PATH__REGISTRATION_PAGE;
            }
            // if OK
            userService.createUser(createUser(userForm));
        } catch (Exception e) {
            model.addAttribute(PathHolder.ATTRIBUTE_NAME__MESSAGE, PathHolder.MESSAGE__INTERNAL_SERVICE_ERROR);
            model.addAttribute(PathHolder.ATTRIBUTE_NAME__USERFORM, userForm);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            LOG.error("Can't save new user " + userForm.getLogin(), e);
            return PathHolder.PATH__REGISTRATION_PAGE;
        }
        attributes.addFlashAttribute(PathHolder.ATTRIBUTE_NAME__MESSAGE, PathHolder.MESSAGE__REGISTRATION_COMPLETE);
        return PathHolder.PATH__REDIRECT + PathHolder.PATH__LOGIN_PAGE;
    }

    @RequestMapping(value = PathHolder.PATH__REQUEST_CHECK_LOGIN, method = RequestMethod.GET)
    public boolean checkLogin(@RequestParam(PathHolder.REQUEST_PARAM__LOGIN) String login) throws Exception {
        return userService.checkLogin(login);
    }

    private User createUser(UserForm form) throws Exception {
        Role role = roleService.getRoleByName(form.getRoleName());
        return new User.UserBuilder().login(form.getLogin()).password(form.getPassword()).email(form.getEmail())
                .firstName(form.getFirstName()).lastName(form.getLastName()).phone(form.getPhone())
                .registration(new Date()).status(UserStatus.DISABLED).role(role).build();
    }
}
