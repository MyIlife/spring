package com.example.spring.anno.lazybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 懒加载：true表示容器初始化完成时不加载，当第一次访问的时候加载，只针对于单例bean
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("容器初始化完成。。。");
        Object person = a.getBean("person");
        System.out.println(((Person) person).getName());
    }
}
