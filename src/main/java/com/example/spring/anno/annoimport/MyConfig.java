package com.example.spring.anno.annoimport;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import(Color.class)
@Import({Color.class,Car.class,MyImporSeletor.class,MyImportBeanDefinitionRegistrar.class})
public class MyConfig {
}
