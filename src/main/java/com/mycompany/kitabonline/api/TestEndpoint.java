package com.mycompany.kitabonline.api;

import com.mycompany.kitabonline.service.UserDetailsServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "publicEndpoint";
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @GetMapping("/method")
    public String methodAdmin() {
        return "method-admin";
    }

    @GetMapping("/me")
    public String getMyself() {
        return ((UserDetails) SecurityContextHolder.getContext().getAuthentication()).getUsername().toString();
    }


}
