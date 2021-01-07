package com.example.spring.anno.autowired;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class MyAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware:"+s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String value = stringValueResolver.resolveStringValue("hello ${os.name}");
    }
}
