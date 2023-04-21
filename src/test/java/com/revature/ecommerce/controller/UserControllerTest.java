package com.revature.ecommerce.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ecommerce.model.User;
import com.revature.ecommerce.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.web.servlet.function.ServerResponse.ok;
import static org.springframework.web.servlet.function.ServerResponse.status;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userServiceTest;

    User testUser1;
    User testUser2;
    User testUser3;
    List<User> testUserList = new ArrayList<>();

    String jsonString(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }

    @BeforeEach
    void setUp() {
        testUser1 = new User(1, "user1", "password1");
        testUser2 = new User(2, "user2", "password2");
        testUser3 = new User(3, "user3", "password3");
        testUserList.add(testUser1);
        testUserList.add(testUser2);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testRegisterUser() throws Exception {
        when(userServiceTest.createNewUser(testUser1)).thenReturn(testUser1);
        this.mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString(testUser1)))
                .andDo(print());
    }

    /*@Test
    void testLoginUser() throws Exception {
        when(userServiceTest.userLogin(testUser2)).thenReturn(Boolean.valueOf("Successful " +
                "login!"));
        this.mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString(testUser2)))
                .andDo(print()).andExpect(content().string("Successful " +
                        "login!"));

    }

    @Test
    void testLoginNonexistentUser() throws Exception {
        when(userServiceTest.userLogin(testUser3)).thenReturn(Boolean.valueOf("There was an error " +
                "logging in."));
        this.mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString(testUser3)))
                .andDo(print());
    }*/
}