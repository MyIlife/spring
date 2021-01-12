1.编写切面类MyAspect，加入注解@Aspect，并添加@Component注册到容器
2.编写切面的切入点方法以及切入点
3.开启切面支持（config类中开启即可）

《源码解读》
1.@EnableAspectJAutoProxy
    -> @Import(AspectJAutoProxyRegistrar.class)
        -> AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);
        //将AnnotationAwareAspectJAutoProxyCreator注册到容器，从继承关系图看出这个类主要两个实现类
        //【BeanPostProcessor】
        //和【BeanFactoryAware】