package com.example.spring.anno.conditional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition1 implements Condition {
    /**
     * 定义规则：如果person2已经注册了，那么person1就不注册
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Object person2 = beanFactory.getBean("person2");
        if(person2!=null){
            return true;
        }
        return false;
    }
}
