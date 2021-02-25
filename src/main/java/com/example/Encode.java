package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Encode {

    @PostMapping("/encode{message}{key}")
    public String encodeThat (@RequestParam String message,
                              @RequestParam String key){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        //incoming message to array
        //incoming array to String Buffer
        StringBuffer arrayToStringMessage = new StringBuffer();

        int counter;
        for (int i = 0; i < message.length(); i++) {

            counter = alphabet.indexOf(message.charAt(i));
            if (counter >= 0){
                arrayToStringMessage.append(key.charAt(counter));
            } else {
                arrayToStringMessage.append(message.charAt(i));
            }
        }


        String newPhrase = arrayToStringMessage.toString();
        //System.out.println(newPhrase);
        return newPhrase;
    }

}
