package com.example.spring.ioc.circularreference;

import org.springframework.beans.factory.annotation.Autowired;

public class MyClass1 {
    @Autowired
    private MyClass2 myClass2;
}
