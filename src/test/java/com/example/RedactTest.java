package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Redact.class)
public class RedactTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void RedactTestMethod() throws Exception{
        this.mvc.perform(get("/redact?original=A little of this and a little of that&badWord=little&badWord=this").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("A ****** of **** and a ****** of that "));
    }

}
