package com.nvm.tiamsbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hi")
    public String printHi() {
        return "Hi! Welcome to TiAMS Application";
    }
}
