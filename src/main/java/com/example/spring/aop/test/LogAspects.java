package com.example.spring.aop.test;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspects {
    @Before("execution(public void com.example.spring.aop.test.UserController.*(..))")
    public void BeforeUserBuy(){
        System.out.println("user buy before");
    }
    @After("execution(public void com.example.spring.aop.test.UserController.*(..))")
    public void afterUserBuy(){
        System.out.println("user buy after");
    }
}
