package com.example.spring.anno.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person1 {
    private Person person;
    private String name;

    /**
     * 标注在有参数构造器上
     * 也可以放方法中的参数前，如果只有一个参数，那么也可以省略
     * @param person
     */
    @Autowired
    Person1(// @Autowired
                     Person person){
        this.person = person;
    }
    Person1(){

    }
    public Person getPerson() {
        return person;
    }

    /**
     * 标注在方法上
     * @param person
     */
/*    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }*/
    public void setPerson(Person person) {
        this.person = person;
    }
}
