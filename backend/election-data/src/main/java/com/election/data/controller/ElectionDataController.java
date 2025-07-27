package com.election.data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElectionDataController {

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }

}
