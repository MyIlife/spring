package com.example.spring.anno.configAndBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    /**
     * 如果不显示指定，那么方法名(people)为容器中的bean的id
     * @return
     */
    @Bean
    public People people(){
        People people = new People();
        people.setName("test");
        people.setSex("女");
        return people;
    }

    /**
     * 也可以通过@Bean指定id
     * @return
     */
    @Bean("thisPerson")
    public Person getPerson(){
        Person p =new Person();
        p.setName("人人");
        p.setAge(11);
        return p;
    }

}
