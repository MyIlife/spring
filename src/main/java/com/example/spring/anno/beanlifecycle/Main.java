package com.example.spring.anno.beanlifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean的创建，属性赋值，初始化方法，销毁方法
 * 一般由容器管理bean生命周期
 * 但用户可以自己定义初始化和销毁方法：
 * init-method(对象创建完成并完成初始化属性赋值)
 * destory-method：单实例对象容器会调用destory方法，但如果是多实例的时候，容器时不会调用destroy方法的
 * 实现方式1：
 *  @Bean(initMethod = "init",destroyMethod = "destroy")
 *  实现方式2：
 *  LifecycleBean1 implements InitializingBean, DisposableBean
 *  实现方式3：JSR250
 *  分别使用注解： @PostConstruct 和@PreDestroy
 *  实现方式4：BeanPostProcessor bean的后置处理器(初始化前后调用)
 *  注意：
 *  postProcessBeforeInitialization 是在bean的初始化之前调用
 *  postProcessAfterInitialization 是在bean初始化完成之后调用
 *  这两个和前面三种方式有区别
 *
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext a= sout();
        a.close();
        /**
         * LifecycleBean 构造器执行
         * BeanPostProcessor执行postProcessBeforeInitialization：lifeCycleBean
         * LifecycleBean 初始化方法调用
         * BeanPostProcessor执行postProcessAfterInitialization：lifeCycleBean
         * 14:29:31.745 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'lifecycleBean1'
         * LifecycleBean1 构造器执行
         * BeanPostProcessor执行postProcessBeforeInitialization：lifecycleBean1
         * LifecycleBean1 初始化方法调用
         * BeanPostProcessor执行postProcessAfterInitialization：lifecycleBean1
         * LifecycleBean2 构造器执行
         * BeanPostProcessor执行postProcessBeforeInitialization：lifeCycleBean2
         * LifecycleBean2 初始化方法调用
         * BeanPostProcessor执行postProcessAfterInitialization：lifeCycleBean2
         * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         * org.springframework.context.annotation.internalCommonAnnotationProcessor
         * org.springframework.context.event.internalEventListenerProcessor
         * org.springframework.context.event.internalEventListenerFactory
         * myConfig
         * lifeCycleBean
         * lifecycleBean1
         * lifeCycleBean2
         * lifeCycleBean3
         * LifecycleBean2 销毁方法调用
         * LifecycleBean1 销毁方法调用
         * LifecycleBean 销毁方法调用
         */
    }
    public static AnnotationConfigApplicationContext sout(){
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = a.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
        }
        return a;
    }
}

