package com.agan.boot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/configHome")
    public String home() {
        return "hello agan!";
    }

}
