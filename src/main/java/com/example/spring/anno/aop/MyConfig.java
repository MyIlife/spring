package com.example.spring.anno.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.spring.anno.aop")
@EnableAspectJAutoProxy
public class MyConfig {

}
