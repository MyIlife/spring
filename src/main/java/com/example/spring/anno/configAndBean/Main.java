package com.example.spring.anno.configAndBean;

import com.example.spring.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 引入主配置文件，并将主配置文件中的bean添加到容器中
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext a =  new AnnotationConfigApplicationContext(MyConfig.class);
        People people = (People)a.getBean("people");
        System.out.println(people.getName());
        Person thisPerson = (Person)a.getBean("thisPerson");
        System.out.println(thisPerson.getName());
        //查看容器中的bean-id
        System.out.println("查看容器中定义的bean的id");
        String[] beanDefinitionNames = a.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
            /**
             * myConfig
             * people
             * thisPerson
             */
        }
    }
}
