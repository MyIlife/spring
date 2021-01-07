package com.example.spring.anno.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.spring.anno.beanlifecycle")
public class MyConfig {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public LifecycleBean lifeCycleBean(){
        return new LifecycleBean();
    }
    @Bean
    public LifecycleBean1 lifecycleBean1(){
        return new LifecycleBean1();
    }

    @Bean
    public LifecycleBean2 lifeCycleBean2(){
        return  new LifecycleBean2();
    }
/*    @Bean
    public LifecycleBean3 lifeCycleBean3(){
        return  new LifecycleBean3();
    }*/
}
