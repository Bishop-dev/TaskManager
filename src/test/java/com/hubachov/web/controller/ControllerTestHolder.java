package com.hubachov.web.controller;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

public class ControllerTestHolder {
    static final String PATH__PREFIX = "/WEB-INF/pages/";
    static final String PATH__SUFFIX = ".jsp";

    static ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(PATH__PREFIX);
        viewResolver.setSuffix(PATH__SUFFIX);
        return viewResolver;
    }
}
