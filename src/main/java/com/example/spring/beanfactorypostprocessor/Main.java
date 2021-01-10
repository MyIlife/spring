package com.example.spring.beanfactorypostprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanFactoryPostProcessor
 * 看源码介绍：
 *  beanfactory标准初始化之后，所有bean-definenation加载，但所有bean没有初始化之前
 */



public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ExConfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
        }
    }
}
