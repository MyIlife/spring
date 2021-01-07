package com.example.spring.anno.autowired;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class MyService {
    private String tag = "123";
    public String reStr(){
        return tag;
    }
}
