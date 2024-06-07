package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 给控制器注册对象
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello World";
    }

    @GetMapping("/hello2")
    public List<String> hello2() {
        return List.of("hello World");
    }

}
