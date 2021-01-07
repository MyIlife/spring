package com.example.spring.anno.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * 按照条件进行判断并注册bean
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = a.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName+":"+a.getBean(beanDefinitionName));
            /**
             * myConfig:com.example.spring.anno.conditional.MyConfig$$EnhancerBySpringCGLIB$$1077222d@69b2283a
             * person2:Person2(name=p1)
             * 由于定了了Person1只在非windows 10条件下注册，所以这里不答应person1
             */
        }
    }
}
