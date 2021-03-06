package com.thoughtworks.capacity.gtb.mvc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.hamcrest.Matchers;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    ResultActions result = null;

    @AfterEach
    void tearDown() throws UnsupportedEncodingException {
        if (result != null) {
            MvcResult mvcResult = result.andReturn();
            String contentAsString = mvcResult.getResponse().getContentAsString();
            System.out.println(contentAsString);
        }
    }

    @Test
    void register() throws Exception {
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("http://localhost:8080/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"\", \"email\":\"123\"}");

        result = mockMvc.perform(req);
        result.andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is(2)));
    }

    @Test
    void login() throws Exception {
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("http://localhost:8080/login?name=zh&password=123456");
        result = mockMvc.perform(req);
        result.andExpect(MockMvcResultMatchers.jsonPath("$.code",Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("name is invalid")));

    }
}