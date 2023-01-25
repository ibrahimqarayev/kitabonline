package com.mycompany.kitabonline.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestEndpoint {

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }


}
