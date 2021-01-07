package com.example.spring.anno.annoimport;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Iterator;
import java.util.Set;

public class MyImporSeletor implements ImportSelector {
    /**
     * 返回值即为要测的组件全类名
     * @param importingClassMetadata 当前被@Import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.example.spring.anno.annoimport.Node"};
    }
}
