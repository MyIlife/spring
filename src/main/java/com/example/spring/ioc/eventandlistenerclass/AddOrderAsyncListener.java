package com.example.spring.ioc.eventandlistenerclass;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
public class AddOrderAsyncListener implements ApplicationListener<AddOrderEvent> {
    @Async
    @Override
    public void onApplicationEvent(AddOrderEvent event) {
        System.out.println(Thread.currentThread().getName()+":异步监听器被调用，当前收到的事件消息内容为："+event.toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Order source = (Order)event.getSource();
        //发送消息队列等 sendTo(source.toJsonString());
    }
}
