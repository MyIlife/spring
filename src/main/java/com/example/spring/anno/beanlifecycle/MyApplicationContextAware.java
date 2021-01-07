package com.example.spring.anno.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 通过实现ApplicationContextAware 可以获得ApplicationContext
 * 原理其实是通过ApplicationContextAwareProcessor设置到ApplicationContextAware
 * 执行过程就是beanPostProcessor的执行过程：
 * MyApplicationContextAware对象初始化前，先对MyApplicationContextAware遍历beanPostProcessor，但执行到ApplicationContextAwareProcessor时，
 * 发现MyApplicationContextAware instanceof ApplicationContextAware，则调用invokeAwareInterfaces()方法把内部维护的ApplicationContext设置到
 * ApplicationContextAware.setApplicationContext(ApplicationContext applicationContext),那么子类也就得到了applicationContext
 */
@Component
public class MyApplicationContextAware implements ApplicationContextAware {
    private ApplicationContext a;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.a = applicationContext;
        System.out.println("得到applicationContext");
    }
}
