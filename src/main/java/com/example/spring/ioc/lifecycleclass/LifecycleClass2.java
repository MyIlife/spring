package com.example.spring.ioc.lifecycleclass;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifecycleClass2{
   public LifecycleClass2(){
        System.out.println("LifecycleClass2对象创建");
    }
    public void init(){
        System.out.println("LifecycleClass2对象初始化之后");
    }
    public void destory(){
        System.out.println("LifecycleClass2对象销毁");
    }
}
