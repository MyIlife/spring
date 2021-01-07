package com.example.spring.anno.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public PeopleFactoryBean peopleFactoryBean(){
        return  new PeopleFactoryBean();
    }
}
