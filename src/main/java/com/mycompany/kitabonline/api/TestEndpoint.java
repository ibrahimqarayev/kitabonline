package com.mycompany.kitabonline.api;

import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/admin")
    public String user() {
        return "user";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "publicEndpoint";
    }

    @GetMapping("/me")
    public String getMyself() {
        return SecurityContextHolder.getContext().getAuthentication().getName().toString();
    }


}
