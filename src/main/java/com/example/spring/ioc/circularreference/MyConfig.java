package com.example.spring.ioc.circularreference;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public MyClass1 myClass1(){
        return new MyClass1();
    }
    @Bean
    public MyClass2 myClass2(){
        return new MyClass2();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanNames = a.getBeanDefinitionNames();
        for (int i = 0; i < beanNames.length; i++) {
            String beanName = beanNames[i];
            System.out.println(beanName);
        }
    }
}
