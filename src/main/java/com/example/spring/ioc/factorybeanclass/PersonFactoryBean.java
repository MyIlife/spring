package com.example.spring.ioc.factorybeanclass;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        Person person = new Person();
        person.setName("我是factorybean创建出来的bean");
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
