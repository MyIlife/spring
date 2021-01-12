package com.example.spring.ioc.lifecycleclass;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LifecycleClass1 implements InitializingBean, DisposableBean {
    public LifecycleClass1(){
        System.out.println("LifecycleClass1对象创建");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("LifecycleClass1对象销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifecycleClass1对象初始化之后");
    }
}
