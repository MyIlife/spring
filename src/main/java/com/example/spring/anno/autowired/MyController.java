package com.example.spring.anno.autowired;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class MyController{
    //自动装配
    @Qualifier("myService1")
    @Autowired
    private MyService myService;

    public String print(){
        return myService.reStr();
    }
}
