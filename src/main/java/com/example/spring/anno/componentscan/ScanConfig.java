package com.example.spring.anno.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@Configuration
//1.只包含一个包
@ComponentScan(value = "com.example.spring.anno.componentscan")
//2.excludeFilters排除规则（可指定注解、指定类型、正则或自定义规则排除）
//@ComponentScan(value = "com.example.spring.anno.componentscan",
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class})})
//3.可定义多个包
//@ComponentScans(value = {
//        @ComponentScan(value = "com.example.spring.anno.componentscan")
//})
public class ScanConfig {
}
