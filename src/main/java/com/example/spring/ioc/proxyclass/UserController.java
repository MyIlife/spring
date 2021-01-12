package com.example.spring.ioc.proxyclass;

import org.springframework.stereotype.Controller;

@Controller
public class UserController implements MyInterface {
    public void buy(String something){
        System.out.println("user buy " + something);
    }
}
