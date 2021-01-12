package com.example.spring.ioc.eventandlistenerclass;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class OrderService {
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    //@Autowired
   // private AnnotationConfigApplicationContext annotationConfigApplicationContext;

    public void addOrder(Order order){
        //insert into order
        //然后触发事件
        AddOrderEvent a = new AddOrderEvent(order);
        //annotationConfigApplicationContext.publishEvent(a);
        eventPublisher.publishEvent(a);
    }
}
