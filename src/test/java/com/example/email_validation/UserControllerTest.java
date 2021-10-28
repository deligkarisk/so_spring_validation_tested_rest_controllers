package com.example.email_validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserControllerTest {


    MockMvc mockMvc;

    @Autowired
    UserController userController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    void emailInvalid() throws Exception {
        mockMvc.perform(post("/users").param("name", "uname")
                        .param( "password", "LongPasswordHere")
                        .param( "email", "email")).andExpect(status().isBadRequest())
                        .andExpect(content().string(containsString("Errors exist")));
    }

    @Test
    void emailValid() throws Exception {
        mockMvc.perform(post("/users").param("name", "uname")
                        .param( "password", "LongPasswordHere")
                        .param( "email", "email@gmail.com")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Success")));
    }
}