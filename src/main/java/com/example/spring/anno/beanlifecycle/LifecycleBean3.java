package com.example.spring.anno.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean3 implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("lifecycleBean1")){
            return null;
        }
        System.out.println("BeanPostProcessor执行postProcessBeforeInitialization："+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("lifecycleBean1")){
            return null;
        }
        System.out.println("BeanPostProcessor执行postProcessAfterInitialization："+beanName);
        return bean;
    }
}
