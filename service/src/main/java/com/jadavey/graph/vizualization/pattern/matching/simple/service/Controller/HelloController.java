package com.jadavey.graph.vizualization.pattern.matching.simple.service.Controller;

import com.jadavey.graph.vizualization.pattern.matching.simple.service.Model.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String hello() {
        Hello dummyObject = new Hello();
        return dummyObject.sayHello();
    }
}
