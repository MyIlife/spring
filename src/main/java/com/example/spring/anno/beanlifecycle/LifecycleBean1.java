package com.example.spring.anno.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifecycleBean1 implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("LifecycleBean1 销毁方法调用");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifecycleBean1 初始化方法调用");
    }
    LifecycleBean1(){
        System.out.println("LifecycleBean1 构造器执行");
    }
}
