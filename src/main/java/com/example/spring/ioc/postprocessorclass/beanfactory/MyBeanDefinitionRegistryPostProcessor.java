package com.example.spring.ioc.postprocessorclass.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 根据官方描述，就是在BeanFactoryPostProcessor前能执行一些添加、删除、查询beandefinition的操作
 * 同时BeanDefinitionRegistryPostProcessor实现了BeanFactoryPostProcessor，那么也具有BeanFactoryPostProcessor的
 * 能力，但始终是有先后执行关系
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor后置处理器MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry执行");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor后置处理器MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory执行");
    }
}
