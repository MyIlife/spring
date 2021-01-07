package com.example.spring.anno.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifecycleBean2 {
    /**
     * bean创建完成，并且属性赋值完成后执行这个方法
     */
    @PostConstruct
    public void init(){
        System.out.println("LifecycleBean2 初始化方法调用");
    }

    /**
     * 在容器移除对象之前调用
     */
    @PreDestroy
    public void destroy(){
        System.out.println("LifecycleBean2 销毁方法调用");
    }
    LifecycleBean2(){
        System.out.println("LifecycleBean2 构造器执行");
    }

}
