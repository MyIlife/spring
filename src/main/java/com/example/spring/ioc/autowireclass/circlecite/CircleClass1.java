package com.example.spring.ioc.autowireclass.circlecite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircleClass1 {
    @Autowired
    private CircleClass2 circleClass2;
}
