package com.example.spring.anno.lazybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MyConfig {
    @Bean
    @Lazy(value = true)
    public Person person(){
        System.out.println("容器初始化完成之后加载。。。");
        Person person = new Person();
        person.setName("ssss");
        return person;
    }
}

