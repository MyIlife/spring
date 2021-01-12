package com.example.spring.anno.aop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用步骤：
 * 1.业务类：UserController
 * 2.切面类：LogAspects
 *      通知方法：
 *          前置通知：Before
 *          后置通知：After
 *          返回通知：AfterReturning
 *          异常通知：AfterThrowing
 *          环绕通知：手动推进目标方法运行(joinPoint.procced())
 * 3.注入切面类LogAspects,并在类上注解@Aspect
 * 4.配置类开启基于注解的aop模式：@EnableAspectJAutoProxy
 *
 * 扩展：
 * @Enablexxx 表示开启某种功能
 *
 * aop原理：
 *@EnableAspectJAutoProxy
 *  @Import(AspectJAutoProxyRegistrar.class)
 *      ImportBeanDefinitionRegistrar（往容器中注册bean的接口）
 *      --1.给容器注册了：AnnotationAwareAspectJAutoProxyCreator
 *                          AspectJAwareAdvisorAutoProxyCreator
 *                                  AbstractAdvisorAutoProxyCreator
 *                                      AbstractAutoProxyCreator
 *                                           extends ProxyProcessorSupport
 * 		                                     implements SmartInstantiationAwareBeanPostProcessor, //bean的后置处理器
 * 		                                     BeanFactoryAware //可获得beanFactory
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(MyConfig.class);
        Object userController = a.getBean("userController");
        ((UserController)userController).buy("车车");
    }
}
