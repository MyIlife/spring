package com.example.spring.anno.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {
    /**
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE 多实例，容器初始化完成不创建，每次获取的时候都从容器中创建一个新的对象
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON （默认）单实例，容器初始化完成之后创建（默认懒加载为false）
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST 同一次请求只创建一次
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION 同一额session只创建一个对象
     */
    @Bean("person")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Person getPerson(){
        System.out.println("person对象被创建");
        Person p =new Person();
        p.setName("人人");
        p.setAge(11);
        return p;
    }

}
