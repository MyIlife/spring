package com.example.spring.ioc.conditionalclass;

import com.example.spring.ioc.IocConfig;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

@Component
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //加载的判断
        Environment environment = context.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();
        boolean flag = false;
        for (int i = 0; i < activeProfiles.length; i++) {
            String activeProfile = activeProfiles[i];
            if(activeProfile.equals(IocConfig.MY_CONDITION)){ //指定激活配置中包含hello时，进行加载
                flag = true;
            }
        }
        return flag;
    }
}
