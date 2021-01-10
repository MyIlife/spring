package com.example.spring.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ListennerConfig.class);
        annotationConfigApplicationContext.publishEvent(new ApplicationEvent("我发布的事件") {
            @Override
            public Object getSource() {
                return super.getSource();
            }

            @Override
            public String toString() {
                return super.toString();
            }
        });
        annotationConfigApplicationContext.close();
    }
}
