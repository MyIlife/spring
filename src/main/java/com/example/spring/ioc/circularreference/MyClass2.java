package com.example.spring.ioc.circularreference;

import org.springframework.beans.factory.annotation.Autowired;

public class MyClass2 {
    @Autowired
    private MyClass1 myClass1;
}
