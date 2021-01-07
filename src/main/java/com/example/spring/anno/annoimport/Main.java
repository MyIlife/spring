package com.example.spring.anno.annoimport;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 往容器中注册组件：
 * 1.包扫描+注解（@Component，@Controller，@Repository）
 * 2.@Configuration+@Bean
 * 3.@Import:快速给容器中导入组件,id 默认为全类路径名
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = sout();
        /**
         * myConfig
         * com.example.spring.anno.annoimport.Color
         * com.example.spring.anno.annoimport.Car
         * com.example.spring.anno.annoimport.Node 这个就是importSelector中指定返回的
         * Tree 这个就是importBeanDefinitionRegistrar注册的
         */
    }
    public static AnnotationConfigApplicationContext sout(){
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = a.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
        }
        return a;
    }
}
