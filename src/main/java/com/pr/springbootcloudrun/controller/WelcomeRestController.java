package com.pr.springbootcloudrun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping
@RestController
public class WelcomeRestController {

    @GetMapping("/")
    public String ping()
    {
        return "Welcome, you are entering at  " + LocalDateTime.now().toString();
    }
}
