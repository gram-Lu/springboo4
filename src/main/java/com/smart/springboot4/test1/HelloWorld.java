package com.smart.springboot4.test1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1")
public class HelloWorld {
    @RequestMapping("/helloWorld")
    public String HelloWorld(){
        return "helloWorld";
    }
}
