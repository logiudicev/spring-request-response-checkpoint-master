package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Redact {

    @GetMapping("/redact{original}")
    public String redactThat (@RequestParam String original){

        String originalPhrase = original;
        String newPhrase = originalPhrase.replace("badWord", "*******");

        return newPhrase;
    }

}
