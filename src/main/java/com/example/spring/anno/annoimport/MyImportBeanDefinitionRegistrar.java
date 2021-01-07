package com.example.spring.anno.annoimport;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        /**
         * 如果容器中有car，就玩容器中注册一个Tree
         */
        boolean isContain = registry.containsBeanDefinition("com.example.spring.anno.annoimport.Car");
        if(isContain){
            registry.registerBeanDefinition("Tree",new RootBeanDefinition(Tree.class));
        }
    }
}
