package com.example.spring.anno.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * scope测试
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext a =  new AnnotationConfigApplicationContext(MyConfig.class);
        Person person1 = (Person)a.getBean("person");
        Person person2 = (Person)a.getBean("person");
        System.out.println(person1==person2);
    }

}
