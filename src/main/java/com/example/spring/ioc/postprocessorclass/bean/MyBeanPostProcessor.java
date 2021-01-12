package com.example.spring.ioc.postprocessorclass.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 初始化前后执行
 * 包括：refresh()方法执行的finishBeanFactoryInitialization(beanFactory);中加载我们定义的bean【非懒加载】
 * 和懒加载之后，调用getBean()
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+":【MyBeanPostProcessor】postProcessBeforeInitialization 执行");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+":【MyBeanPostProcessor】postProcessAfterInitialization 执行");
        return bean;
    }
}
