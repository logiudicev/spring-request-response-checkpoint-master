package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Redact {

    @GetMapping("/redact{original}{badWord}")
    public String redactThat (@RequestParam String original,
                              @RequestParam String badWord)
    {
        String [] wordArray = original.split(" ");
        String [] badWordArray = badWord.split (",");
        String badWord1 = badWordArray[0];
        String badWord2 = badWordArray[1];
        String badWord1rep = "****** ";
        String badWord2rep = "**** ";
        StringBuffer arrayToStringWords = new StringBuffer();

        int phraseLength = wordArray.length;
        phraseLength = phraseLength - 1;

        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i].equals(badWord1)) {
                arrayToStringWords.append(badWord1rep);
            } else if (wordArray[i].equals(badWord2))  {
                arrayToStringWords.append(badWord2rep);
            }



            else if (i <= arrayToStringWords.length()){
                arrayToStringWords.append(wordArray[i] + " ");
            } else {
                arrayToStringWords.append(wordArray[i]);
            }


            /*
            if (wordArray[i].matches("little")) {
                wordArray[i].replace("little", " ****** ");
                arrayToStringWords.append(wordArray[i]);
            } else if (wordArray[i].matches("this")) {
                wordArray[i].replace(" **** ", "this");
                arrayToStringWords.append(wordArray[i]);
            } else {
                arrayToStringWords.append(wordArray[i]);
            }
            */

            //original = wordArray[i];
        }
        //int phraseLength = arrayToStringWords.length();
        //arrayToStringWords.deleteCharAt(phraseLength);
        arrayToStringWords.deleteCharAt(arrayToStringWords.length()-1);
        String newPhrase = arrayToStringWords.toString();
        //String originalPhrase = original;
        //String newPhrase = originalPhrase.replace("badWord", "*******");

        return newPhrase ;
    }

}
