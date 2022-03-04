package ru.job4j.dreamjob.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexControl {

    @GetMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
