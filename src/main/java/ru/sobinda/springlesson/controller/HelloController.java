package ru.sobinda.springlesson.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@ConfigurationProperties("hello")
//public class HelloController {
//
//    private String from;
//
//public void setFrom(String from) {
//        this.from = from;
//        }
//    @GetMapping("/")
//    private String hello() {
//        return String.format("Hello %s", from);
//    }
//}

@RestController
public class HelloController {
    @Value("${hello.from:undefined}")

    private String from;


    @GetMapping("/")
    private String hello() {
        return String.format("Hello %s", from);
    }
}
