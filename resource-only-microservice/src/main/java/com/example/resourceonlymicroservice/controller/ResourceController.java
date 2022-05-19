package com.example.resourceonlymicroservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micoservice2/api/messages")
public class ResourceController {

    @GetMapping
    public String consumeMsgs(){
        return "ELsalam Alikom";
    }


}
