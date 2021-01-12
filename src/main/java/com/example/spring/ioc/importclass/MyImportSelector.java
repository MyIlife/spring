package com.example.spring.ioc.importclass;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * 通过selector的方式注入类，返回的String[]中保存的是类的全路径+类名
 * 应用场景：选择性的注入一部分类
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{ImportClass2.class.getName()};
    }
}
