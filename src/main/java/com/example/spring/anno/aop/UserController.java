package com.example.spring.anno.aop;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    public void buy(String something){
        System.out.println("user buy " + something);
    }
}