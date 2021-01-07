package com.example.spring.anno.value;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Person {
    /**
     * 1.基本类型的值、string等
     * 2.SpEL，#{ }
     * 3.读取配置文件,${}  (在运行环境变量中的值)
     */
    @Value("我啊")
    private String name;
    @Value("#{22}")
    private int age;
    @Value("${person.sex}")
    private String sex;

}
