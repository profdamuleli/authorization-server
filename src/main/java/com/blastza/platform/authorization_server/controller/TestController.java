package com.blastza.platform.authorization_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
public class TestController {

    @GetMapping()
    public String healthCheck() {
        return "Service is up and running and secured";
    }

}
