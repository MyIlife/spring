1.BeanFactoryPostProcessor是通过调用链：
refresh()-》invokeBeanFactoryPostProcessors(beanFactory)-》
-》执行postProcessBeanFactory(registry)
2.BeanDefinitionRegistryPostProcessor是实现了BeanFactoryPostProcessor，调用在
所有BeanFactoryPostProcessor之前，同时BeanDefinitionRegistryPostProcessor实现了BeanFactoryPostProcessor，
那么也具有BeanFactoryPostProcessor的能力，但始终是有先后执行关系