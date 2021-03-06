package com.aura.training.dashboard.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "/index.html";
    }
}
