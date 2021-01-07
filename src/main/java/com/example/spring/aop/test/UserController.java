package com.example.spring.aop.test;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    public void buy(){
        System.out.println("user buy");
    }
}
