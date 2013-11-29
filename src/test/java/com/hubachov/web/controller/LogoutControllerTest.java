package com.hubachov.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static junit.framework.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LogoutControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private LogoutController controller;

    @Before
    public void before() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(ControllerTestHolder.viewResolver()).
                build();
    }

    @Test
    public void testPageAfterLogout() throws Exception {
        ResultActions actions = mockMvc.perform(get(PathHolder.PATH__REQUEST_LOGOUT));
        actions.andExpect(status().isFound());
        actions.andExpect(view().name(PathHolder.PATH__REDIRECT + PathHolder.PATH__LOGIN_PAGE));
        actions.andExpect(redirectedUrl(PathHolder.PATH__LOGIN_PAGE));
        MvcResult result = actions.andReturn();
        assertNull(result.getRequest().getSession().getAttribute("user"));
    }
}
