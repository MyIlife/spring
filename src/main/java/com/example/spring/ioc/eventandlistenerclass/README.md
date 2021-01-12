1.创建一个事件类AddOrderEvent实现ApplicationEvent，根据需要可维护一个成员变量
用于保存发布事件的具体消息内容，并通过构造器设置值，维护一个get方法返回这个变量
2.创建一个监听器实现ApplicationListener<E extends ApplicationEvent>的onApplicationEvent(E event)
方法，然后将这个监听器添加注解@Component注入容器。并在该监听器
（或者全局配置类）中开启异步调用功能@EnableAsync
3.如果使用异步调用的话可在方法中开启@Async,并且在容器中注入一个taskExecutor

《源码解读》
1.在业务类中注入ApplicationEventPublisher（实现类也是可以的，底层就是调用了实现类，但是如果实现类不确定的话最好还是用这个）
2.调用publishEvent(ApplicationEvent event)
    -> AbstractApplicationContext.publishEvent(ApplicationEvent event) //实现类调用
    -> getApplicationEventMulticaster().multicastEvent(applicationEvent, eventType); //获取事件分发器，并添加事件
        -> SimpleApplicationEventMulticaster.(final ApplicationEvent event, @Nullable ResolvableType eventType)
        //1.先获取线程池Executor executor = getTaskExecutor();
        //2.遍历所有和该事件有关的listener
            //1.如果线程池不为空则使用异步调用invokeListener(listener, event)
            //2.如果线程池为空，则同步调用invokeListener(listener, event)
                ->invokeListener(listener, event)
                    ->listener.onApplicationEvent(event); //执行所有listener的onApplicationEvent方法