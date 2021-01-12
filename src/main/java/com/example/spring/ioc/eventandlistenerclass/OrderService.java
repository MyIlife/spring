package com.example.spring.ioc.eventandlistenerclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class OrderService {
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    public void addOrder(Order order){
        //insert into order
        //然后触发事件
        AddOrderEvent a = new AddOrderEvent(order);
        eventPublisher.publishEvent(a);
    }
}
