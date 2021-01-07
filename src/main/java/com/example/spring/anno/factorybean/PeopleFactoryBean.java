package com.example.spring.anno.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class PeopleFactoryBean implements FactoryBean<People> {
    /**
     * 这个对象会被注册到容器中
     * @return
     * @throws Exception
     */
    @Override
    public People getObject() throws Exception {
        People p = new People();
        p.setName("factorybean生成");
        return p;
    }

    @Override
    public Class<?> getObjectType() {
        return People.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
