package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoCtl {

    @RequestMapping(value = "index")
    public String index(){
        return "hello world";
    }

}
