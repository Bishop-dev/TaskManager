package com.hubachov.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {


    @RequestMapping(value = PathHolder.PATH__REQUEST_LOGOUT, method = RequestMethod.GET)
    public String logout() {
        return PathHolder.PATH__REDIRECT + PathHolder.PATH__LOGIN_PAGE;
    }
}
