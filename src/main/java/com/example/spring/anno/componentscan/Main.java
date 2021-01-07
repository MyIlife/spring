package com.example.spring.anno.componentscan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过主配置文件定义的包注解扫描，将对用的bean加入到容器中
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(ScanConfig.class);
        String[] beanDefinitionNames = a.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
            /**
             * scanConfig
             * bean1
             * bean2
             * bean3
             */
        }
    }
}

