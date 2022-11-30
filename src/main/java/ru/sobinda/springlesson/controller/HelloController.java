package ru.sobinda.springlesson.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.sobinda.springlesson.domain.Person;

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


//    @GetMapping("/")
//    private String hello() {
//        return String.format("Hello %s", from);
//    }

    @PostMapping("/hello")
    private String hello(@RequestBody Person guest) {
        return String.format("Hello from %s to name %s age %d", from, guest.getName(), guest.getAge());
    }

    @GetMapping("/helloGet")
    private String helloGet(Person guest) {
        return String.format("Hello from %s to name %s age %d", from, guest.getName(), guest.getAge());
    }

    @GetMapping("/helloGet2")
    private String helloGet2(@RequestParam("name") String name,
                             @RequestParam("age") int age) {
        return String.format("Hello from %s to name %s age %d", from, name, age);
    }
}
