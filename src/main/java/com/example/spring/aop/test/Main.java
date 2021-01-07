package com.example.spring.aop.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1.业务类：UserController
 * 2.切面类：LogAspects
 *      通知方法：
 *          前置通知：
 *          后置通知：
 *          返回通知：
 *          异常通知：
 *          环绕通知：手动推进目标方法运行
 * 3.注入切面类
 * 4.开启基于注解的aop模式：@EnableAspectJAutoProxy
 * 5.@Enablexxx 表示开启某种功能
 *
 *
 * aop原理：
 *
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(MyConfig.class);
        Object userController = a.getBean("userController");
        ((UserController)userController).buy();
    }
}
