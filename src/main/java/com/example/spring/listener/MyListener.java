package com.example.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *事件模型开发
 * ContextRefreshedEvent : 容器刷新完成事件
 * ContextClosedEvent : 容器关闭事件
 */
@Component
public class MyListener  implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件："+event);
    }
}
