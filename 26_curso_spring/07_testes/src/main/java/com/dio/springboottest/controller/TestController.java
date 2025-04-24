package com.dio.springboottest.controller;


import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    @GetMapping("/test")
    public String saudacao(@RequestParam(name="nome", defaultValue = "DIO") String nome){
        return String.format("Saudacao: %s",nome);
    }

}
