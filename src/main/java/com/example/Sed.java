package com.example;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sed {

    @PostMapping("/s/{little}/{lot}")
    public String sedThis(@PathVariable("little") String find,
                          @PathVariable("lot") String replacement) {
        //what the output is originally
        String original = "a little of this and a little of that";
        //make an array to split each word into its own element
        String[] originalArray = original.split(" ");
        //make a stringbuffer object to hold new string
        StringBuffer newPhraseSB = new StringBuffer();
        //for loop to parse through the array and find elements that
        //equal the @Pathvariable find. If it finds it, it appends the
        //string buffer the new replacement word and adds a space.
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i].equals(find)) {
                newPhraseSB.append(replacement + " ");
            }
            //if the find key is not equal, it will append the next element
            //in i from the array to the string buffer following a " ".
            else {
                newPhraseSB.append(originalArray[i] + " ");
            }
        }
        //remove unwanted space at the end of the string buffer
        newPhraseSB.deleteCharAt(newPhraseSB.length()-1);
        //pass it onto the string
        String newPhrase = newPhraseSB.toString();
        return newPhrase;
    }
}