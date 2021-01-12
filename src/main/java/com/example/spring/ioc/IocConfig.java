package com.example.spring.ioc;


import com.example.spring.ioc.conditionalclass.ConditionalClass1;
import com.example.spring.ioc.conditionalclass.ConditionalClass2;
import com.example.spring.ioc.conditionalclass.MyCondition;
import com.example.spring.ioc.conditionalclass.MyCondition1;
import com.example.spring.ioc.eventandlistenerclass.Order;
import com.example.spring.ioc.eventandlistenerclass.OrderService;
import com.example.spring.ioc.factorybeanclass.Person;
import com.example.spring.ioc.factorybeanclass.PersonFactoryBean;
import com.example.spring.ioc.importclass.MyImportBeanDefinitionRegistrar;
import com.example.spring.ioc.importclass.MyImportSelector;
import com.example.spring.ioc.importclass.ImportClass1;
import com.example.spring.ioc.lazyclass.MyLazyClass;
import com.example.spring.ioc.lifecycleclass.LifecycleClass2;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Import({ImportClass1.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
/*@ComponentScan("com.example.spring.ioc.autowireclass")
@ComponentScan("com.example.spring.ioc.lifecycleclass")*/
@ComponentScans(value = {
        @ComponentScan("com.example.spring.ioc.autowireclass"),
        @ComponentScan("com.example.spring.ioc.lifecycleclass"),
        @ComponentScan("com.example.spring.ioc.postprocessorclass"),
        @ComponentScan("com.example.spring.ioc.factorybeanclass"),
        @ComponentScan("com.example.spring.ioc.eventandlistenerclass")
})
//开启异步调用
@EnableAsync
@Configuration
public class IocConfig {
    public static final String MY_CONDITION = "hello";


    @Bean("myConditionalClass1")
    @Conditional(MyCondition.class) // 指定有Profile 有hello时才加载
    public ConditionalClass1 conditionalClass1(){
        return new ConditionalClass1();
    }
    @Bean("myConditionalClass2")
    @Conditional(MyCondition1.class) // windows 10条件下不加载
    public ConditionalClass2 conditionalClass2(){
        return new ConditionalClass2();
    }

    @Bean(initMethod = "init",destroyMethod = "destory")
    public LifecycleClass2 lifecycleClass2(){
        return new LifecycleClass2();
    }

    @Bean
    @Lazy(value = true)
    public MyLazyClass myLazyClass(){
        return  new MyLazyClass();
    }

    @Bean
    public Person person(){
        Person p = new Person();
        p.setName("我是正常的通过@Bean创建出来的bean");
        return p;
    }

    /**
     * 开启异步调用@Async时，虽然使用的是容器默认线程池配置，而且也能执行成功，但是会报错，所以这里配置一下线程池taskExecutor
     * @return
     */
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);        // 设置核心线程数
        executor.setMaxPoolSize(10);        // 设置最大线程数
        executor.setQueueCapacity(1000);      // 设置队列容量
        executor.setKeepAliveSeconds(60);   // 设置线程活跃时间（秒）
        executor.setThreadNamePrefix("container-");  // 设置默认线程名称
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());// 设置拒绝策略,让提交的线程去执行
        executor.setWaitForTasksToCompleteOnShutdown(true); // 等待所有任务结束后再关闭线程池
        return executor;
    }


    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = applicationContext();
        Object taskExecutor = applicationContext.getBean("taskExecutor");
        /**
         * 懒加载测试
         */
        MyLazyClass myLazyClass = (MyLazyClass)applicationContext.getBean("myLazyClass");
        /**
         * FactoryBean测试
         */
        Object personFactoryBean = applicationContext.getBean("personFactoryBean");
        Person person1 =(Person) applicationContext.getBean("person");
        System.out.println(person1.getName());
        if(personFactoryBean instanceof Person){
            Person person = (Person)personFactoryBean;
            System.out.println(person.getName());
            System.out.println("通过factoryBean创建的bean和@Bean得到的bean是同一个吗："+(person==person1));
        }else if(personFactoryBean instanceof PersonFactoryBean){
            System.out.println("创建了一个工厂bean");
        }
        /**
         * 事件发布和监听测试
         */
        OrderService orderService = (OrderService)applicationContext.getBean("orderService");
        Order o = new Order();
        o.setId(2342);
        o.setName("肥皂");
        o.setPrice(new BigDecimal(12));
        for (int i = 0; i < 100; i++) {
            orderService.addOrder(o);
        }
        System.out.println("事件发送结束");
        applicationContext.close();
    }
    public static AnnotationConfigApplicationContext applicationContext(){
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext();
        a.getEnvironment().addActiveProfile("hello");
        a.register(IocConfig.class);
        a.refresh();
        String[] beanDefinitionNames = a.getBeanDefinitionNames();
        System.out.println("容器中所有定义的bean。以下=========================================");
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
        }
        System.out.println("容器中所有定义的bean。以上=========================================");
        return a;
    }
}
