package com.example.clientresourcemicroservice.controller;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/messages")
public class MicroserviceController {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String accessMicroservic2(Authentication auth){

        Jwt jwt = (Jwt) auth.getPrincipal();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+jwt.getTokenValue());

        String msg = restTemplate.exchange(
                "http://localhost:8086/micoservice2/api/messages",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class
        ).getBody();

        return msg;
    }

}
