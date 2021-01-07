package com.example.spring.anno.beanlifecycle;


public class LifecycleBean {
    LifecycleBean(){
        System.out.println("LifecycleBean 构造器执行");
    }
    public void init(){
        System.out.println("LifecycleBean 初始化方法调用");
    }
    public void destroy(){
        System.out.println("LifecycleBean 销毁方法调用");
    }
}
