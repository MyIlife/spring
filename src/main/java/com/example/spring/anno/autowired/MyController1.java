package com.example.spring.anno.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class MyController1 {
    @Resource(name = "myService2")
    private MyService myService;

    public String print(){
        return myService.reStr();
    }
}
