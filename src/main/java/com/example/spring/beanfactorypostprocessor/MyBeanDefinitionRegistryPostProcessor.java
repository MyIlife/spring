package com.example.spring.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 优先于BeanFactoryPostProcessor执行，可以容器中额外添加一些组件
 * 原理：
 * 1.ioc-》refresh()
 * 2.invokeBeanFactoryPostProcessors(beanFactory);
 * 3.conf容器中获取所有BeanDefinitionRegistryPostProcessor
 * 4.执行所有BeanDefinitionRegistryPostProcessor
 * 5.执行所有BeanFactoryPostProcessor
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
