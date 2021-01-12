package com.example.spring.ioc.autowireclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    @Autowired
    private MyService myService;
}
