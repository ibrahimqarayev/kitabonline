package com.mycompany.kitabonline.config;

import com.mycompany.kitabonline.entity.Role;
import com.mycompany.kitabonline.entity.User;
import com.mycompany.kitabonline.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupConfig implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {

        userService.createUser(User.builder()
                .username("root")
                .password("root")
                .email("qarayevibrahimm@gmail.com")
                .role(Role.ADMIN)
                .build());

    }
}
