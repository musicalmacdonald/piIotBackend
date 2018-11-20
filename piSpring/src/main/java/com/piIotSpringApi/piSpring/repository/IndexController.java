package com.piIotSpringApi.piSpring.repository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String sayHello() {
        return "Hello and Welcome to MEGAN'S Pi Iot Spring Boot API. " +
                "You can create new Data by making a POST request to /api/data endpoint.";
    }
}