package com.example;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Encode.class)
public class EncodeTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void EncodeTestMethod() throws Exception{
        this.mvc.perform(post("/encode?message=a little of this and a little of that&key=mcxrstunopqabyzdefghijklvw").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("m aohhas zt hnog myr m aohhas zt hnmh"));
    }

}
