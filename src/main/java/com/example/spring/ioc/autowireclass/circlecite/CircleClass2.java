package com.example.spring.ioc.autowireclass.circlecite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CircleClass2 {
    @Autowired
    private CircleClass1 circleClass1;
}
