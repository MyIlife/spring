package com.example.spring.anno.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {
    /**
     * 定义规则：window 10不注册bean
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        context.getBeanFactory();
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        if(property.equals("Windows 10")){
            return false;
        }else{
            return true;
        }
    }
}
