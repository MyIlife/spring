package com.example.spring.anno.value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//设置配置资源路径
@PropertySource(value = {"classpath:/application.properties"})
public class MyConfig {
    @Bean
    public Person person(){
        return  new Person();
    }
}
