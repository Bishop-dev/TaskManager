package com.hubachov.web.controller;

public class PathHolder {
    static final String PATH__REQUEST_ROOT = "/";
    static final String PATH__REQUEST_INDEX = "/index";
    static final String PATH__REQUEST_LOGIN = "/login";
    static final String PATH__REQUEST_LOGIN_FAIL = "/login-fail";
    static final String PATH__REQUEST_LOGOUT = "/logout";
    static final String PATH__REQUEST_CHECK_LOGIN = "/checkLogin";

    static final String PATH__INDEX_PAGE = "index";
    static final String PATH__LOGIN_PAGE = "login";
    static final String PATH__REGISTRATION_PAGE = "registration";
    static final String PATH__REDIRECT = "redirect:";

    static final String REQUEST_PARAM__LOGIN="login";

    static final String MESSAGE__LOGIN_FAIL = "Wrong login/password";
    static final String MESSAGE__SERVER_ERROR = "Error happened. Try again.";
    static final String MESSAGE__WRONG_CAPTCHA = "Wrong captcha";
    static final String MESSAGE__WRONG_USER_DATA = "Wrong registration data";
    static final String MESSAGE__INTERNAL_SERVICE_ERROR = "Internal error. Try again.";
    static final String MESSAGE__LOGIN_BUSY = "Login busy. Try another one.";
    static final String MESSAGE__REGISTRATION_COMPLETE = "You may enter using your login and password.";

    static final String LOG_MESSAGE__USER_NOT_FOUND = "Can't find user and set it to session";

    static final String SESSION_ATTRIBUTE_NAME__USER = "user";

    static final String ATTRIBUTE_NAME__MESSAGE = "message";
    static final String ATTRIBUTE_NAME__USERFORM = "userForm";
}
