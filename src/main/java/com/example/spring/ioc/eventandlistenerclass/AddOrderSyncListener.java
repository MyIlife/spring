package com.example.spring.ioc.eventandlistenerclass;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
public class AddOrderSyncListener implements ApplicationListener<AddOrderEvent> {
    @Override
    public void onApplicationEvent(AddOrderEvent event) {
        System.out.println("同步监听器被调用，当前收到的事件消息内容为："+event.toString());
        Order source = (Order)event.getSource();
        //发送消息队列等 sendTo(source.toJsonString());
    }
}
