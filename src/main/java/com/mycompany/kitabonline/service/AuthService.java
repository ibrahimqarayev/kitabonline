package com.mycompany.kitabonline.service;

import com.mycompany.kitabonline.dto.TokenResponseDto;
import com.mycompany.kitabonline.request.LoginRequest;
import com.mycompany.kitabonline.util.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;

    public TokenResponseDto login(LoginRequest loginRequest) {
    }
}
