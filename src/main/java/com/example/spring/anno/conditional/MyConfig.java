package com.example.spring.anno.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    /**
     * person1只有在MyCondition中的方法返回为true是才注入容器
     * @return
     */
    @Bean
    @Conditional(MyCondition.class)
    public Person1 person1(){
        Person1 p = new Person1();
        p.setName("p1");
        return p;
    }
    @Bean
    public Person2 person2(){
        Person2 p = new Person2();
        p.setName("p1");
        return p;
    }
}
