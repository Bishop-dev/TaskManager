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


    @RequestMapping(value = {PathHolder.PATH__REQUEST_ROOT, PathHolder.PATH__REQUEST_LOGIN}, method = RequestMethod.GET)
    public String login() {
        return PathHolder.PATH__LOGIN_PAGE;
    }

    @RequestMapping(value = PathHolder.PATH__REQUEST_LOGIN_FAIL, method = RequestMethod.GET)
    public String loginFail(Map<String, Object> map) {
        map.put(PathHolder.ATTRIBUTE_NAME__MESSAGE, PathHolder.MESSAGE__LOGIN_FAIL);
        return PathHolder.PATH__LOGIN_PAGE;
    }

    @RequestMapping(value = PathHolder.PATH__REQUEST_INDEX, method = RequestMethod.GET)
    public String index(HttpServletRequest request, Principal principal, Map<String, Object> map) {
        String login = principal.getName();
        if (login != null) {
            try {
                request.getSession().setAttribute(PathHolder.SESSION_ATTRIBUTE_NAME__USER, userService.getUserByLogin(login));
            } catch (Exception e) {
                log.error(PathHolder.LOG_MESSAGE__USER_NOT_FOUND, e);
                map.put(PathHolder.ATTRIBUTE_NAME__MESSAGE, PathHolder.MESSAGE__SERVER_ERROR);
                return PathHolder.PATH__LOGIN_PAGE;
            }
        }
        if (request.isUserInRole("admin")) {
            return PathHolder.PATH__INDEX_PAGE;
        }
        if (request.isUserInRole("user")) {
            return PathHolder.PATH__INDEX_PAGE;
        }
        return PathHolder.PATH__LOGIN_PAGE;
    }
}
