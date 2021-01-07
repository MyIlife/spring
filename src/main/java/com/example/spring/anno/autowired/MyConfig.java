package com.example.spring.anno.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.example.spring.anno.autowired")
public class MyConfig {
    @Bean("myService1")
    public MyService myService1(){
        MyService myService = new MyService();
        myService.setTag("456");
        return myService;
    }
    @Primary
    @Bean("myService2")
    public MyService myService2(){
        MyService myService = new MyService();
        myService.setTag("789");
        return myService;
    }
    @Bean
    public Person1 person11(Person person){
        Person1 person1 = new Person1();
        person1.setPerson(person);
        return person1;
    }
}
