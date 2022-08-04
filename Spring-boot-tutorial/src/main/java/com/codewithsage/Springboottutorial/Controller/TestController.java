package com.codewithsage.Springboottutorial.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${welcome.message}")
    private String message;
    @GetMapping()
    public String helloWorld(){
        return message;
    }
}
