package com.example.spring.anno.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * --------------@Autowired ：
 * @Controller
 * public class MyController{
 *     //自动装配
 *     //@Qualifier("myService1")
 *     @Autowired
 *     private MyService myService;
 *     }
 * 1.默认按照类型去ioc容器中寻找，a.getBean(Myservice.class)
 * 2.如果找到多个那么则按照注入的属性名myService作为id去找
 * 3.如果@Qualifier和 @Autowired组合使用，那么会按照@Qualifier中指定的bean_id，也就是myService1去寻找
 * 4.没有找到的话，就会报错
 * 5.如果设置  @Autowired(required=false),就可以允许找不到
 * 6.@Primary，设置自动装配的首选,但如果有@Qualifier则以@Qualifier为主
 *
 *
 * --------------@Resource、@Inject：
 * spring还支持@Resource（JSR250）和@Inject(JSR330)注解[Java的规范注解]
 * @Resource    默认是属性名装配，也可以指定bean_id装配，如@Resource(name = "myService2")，不支持@Primary，也无法像
 *              @Autowired(required=false)一样能屏蔽找不到注入的对象而报错的处理
 * @Inject 需要加入依赖javax.inject,和@Autowired类似，没有@Autowired(required=false)可以使用
 *
 *
 * --------------@Autowired:用于其他如：
 * 构造器，方法,放在方法的参数上的话可以省略
 * 也可以放在@Bean定义的方法参数上，可以省略。
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = applicationContext();
        MyController c = (MyController)a.getBean("myController");
        System.out.println(c.print());
        MyController1 c1 = (MyController1)a.getBean("myController1");
        System.out.println(c1.print());
        MyController2 c2 = (MyController2)a.getBean("myController2");
        System.out.println(c2.print());

        //autowired的其他用法:1.标注在方法上，2.有参构造器
        Person1 peson1 = (Person1)a.getBean("person1");
        Person person = peson1.getPerson();
        Person personp = (Person)a.getBean("person");
        System.out.println(person==personp);
        // @Bean中使用
        Person1 peson11 = (Person1)a.getBean("person11");
        Person p = peson11.getPerson();
        Person pp = (Person)a.getBean("person");
        System.out.println(p==pp);
    }
    public static AnnotationConfigApplicationContext applicationContext(){
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = a.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
        }
        return a;
    }
}

