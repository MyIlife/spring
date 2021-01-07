package com.example.spring.test;

import com.example.spring.bean.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = (AnnotationConfigApplicationContext)testAnnotation();
        a.register(People.class);

    }
    public static ApplicationContext testXml(){
        return new ClassPathXmlApplicationContext("bean.xml");
    }
    public static ApplicationContext testAnnotation(){
        return  new AnnotationConfigApplicationContext();
    }
}
