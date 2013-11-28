package com.hubachov.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LoginControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private LoginController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(ControllerTestHolder.viewResolver()).
                build();
    }

    @Test
    public void testGetLoginPage() throws Exception {
        List<String> list = Arrays.asList(LoginController.PATH__REQUEST_ROOT, LoginController.PATH__REQUEST_LOGIN);
        for (String path : list) {
            ResultActions actions = mockMvc.perform(get(path));
            actions.andExpect(status().isOk());
            actions.andExpect(view().name(LoginController.PATH__LOGIN_PAGE));
            actions.andExpect(forwardedUrl(ControllerTestHolder.PATH__PREFIX + LoginController.PATH__LOGIN_PAGE +
                    ControllerTestHolder.PATH__SUFFIX));
        }
    }

    @Test
    public void testLoginFail() throws Exception {
        ResultActions actions = mockMvc.perform(get(LoginController.PATH__REQUEST_LOGIN_FAIL));
        actions.andExpect(status().isOk());
        actions.andExpect(view().name(LoginController.PATH__LOGIN_PAGE));
        actions.andExpect(forwardedUrl(ControllerTestHolder.PATH__PREFIX + LoginController.PATH__LOGIN_PAGE +
                ControllerTestHolder.PATH__SUFFIX));
    }

}
