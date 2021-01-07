package com.example.spring.anno.autowired;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.inject.Inject;

@Controller
public class MyController2 {
    @Inject
    private MyService myService;

    public String print(){
        return myService.reStr();
    }
}
