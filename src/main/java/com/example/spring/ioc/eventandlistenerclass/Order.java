package com.example.spring.ioc.eventandlistenerclass;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private int id;
    private String name;
    private BigDecimal price;
}
