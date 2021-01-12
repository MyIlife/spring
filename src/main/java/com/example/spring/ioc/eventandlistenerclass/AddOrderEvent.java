package com.example.spring.ioc.eventandlistenerclass;

import org.springframework.context.ApplicationEvent;

public class AddOrderEvent extends ApplicationEvent {
    private Object source;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public AddOrderEvent(Object source) {
        super(source);
        this.source = source;
    }
    public Object getSource(){
        return source;
    }
}
