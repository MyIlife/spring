package com.example.spring.anno.factorybean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext sout = sout();
        //获取的是这个工厂创建的bean
        Object peopleFactoryBean = sout.getBean("peopleFactoryBean");
        if(peopleFactoryBean instanceof People){
            System.out.println("this is a people");
        }else if(peopleFactoryBean instanceof PeopleFactoryBean){
            System.out.println("this is a peopleFactoryBean");
        }     //this is a people
        //通过 & 可以拿到工厂
        Object peopleFactoryBean1 = sout.getBean(BeanFactory.FACTORY_BEAN_PREFIX+"peopleFactoryBean");
        if(peopleFactoryBean1 instanceof People){
            System.out.println("this is a people");
        }else if(peopleFactoryBean1 instanceof PeopleFactoryBean){
            System.out.println("this is a peopleFactoryBean");
        }//this is a peopleFactoryBean
    }
    public static AnnotationConfigApplicationContext sout(){
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = a.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
            /**
             * myConfig
             * peopleFactoryBean
             */
        }
        return a;
    }
}
