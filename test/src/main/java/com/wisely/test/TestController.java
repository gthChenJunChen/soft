package com.wisely.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    public String index() {
        return helloService.sayHello();
    }
}
