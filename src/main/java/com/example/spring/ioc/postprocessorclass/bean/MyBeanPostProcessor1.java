package com.example.spring.ioc.postprocessorclass.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 我们可以专门为某个特定的类定义一个post-processor
 */
@Component
public class MyBeanPostProcessor1 implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof PostProcessorTest){ //只有当这个对象是PostProcessorTest时，我们才执行我们的业务逻辑
            System.out.println(beanName+":【MyBeanPostProcessor11111】postProcessBeforeInitialization 执行");
            return null;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof PostProcessorTest){
            System.out.println(beanName+":【MyBeanPostProcessor11111】postProcessAfterInitialization 执行");
            return null;
        }
        return bean;
    }
}
