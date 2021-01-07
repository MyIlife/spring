package com.example.spring.anno.value;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = sout();
        Person person =(Person) a.getBean("person");
        System.out.println(person.toString());
    }
    public static AnnotationConfigApplicationContext sout(){
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = a.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
        }
        return a;
    }
}
