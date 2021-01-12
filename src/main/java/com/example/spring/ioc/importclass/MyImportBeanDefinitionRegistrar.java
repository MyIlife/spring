package com.example.spring.ioc.importclass;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 相对于ImportSelector，这个实现类能拿到registry,那么可以做一些比较灵活的事情
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //如果ImportClass2的bean定义信息已经注册了，先移除ImportClass2再注册ImportClass3
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            if(beanDefinitionName.equals(ImportClass2.class.getName())){
                registry.removeBeanDefinition(ImportClass2.class.getName());
            }
        }
        BeanDefinition b = new RootBeanDefinition(ImportClass3.class);
        registry.registerBeanDefinition("import3",b);
    }
}
