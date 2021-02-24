package com.example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelCase {

    @GetMapping("/camelize{original}")
    public String camelizeThis(@RequestParam String original,
                               @RequestParam (required = false, defaultValue = "false") boolean initialCap){
        String[] parts = original.split("_");
        String camelCaseString ="";

        for (String part : parts) {
            camelCaseString = camelCaseString + toProperCase(part);
        }
        String result = camelCaseString.substring(0,1).toLowerCase()+camelCaseString.substring(1);
        return result;
    }

    private String toProperCase(String part) {
        return part.substring(0, 1).toUpperCase()+ part.substring(1).toLowerCase();
    }


}
