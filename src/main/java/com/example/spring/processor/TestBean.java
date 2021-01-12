package com.example.spring.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestBean {
    @Autowired
    private MyBeanFactoryPostProcessor myBeanFactoryPostProcessor;
}
