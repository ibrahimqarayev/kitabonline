package com.mycompany.kitabonline.service;

import com.mycompany.kitabonline.dto.TokenResponseDto;
import com.mycompany.kitabonline.exception.GenericException;
import com.mycompany.kitabonline.request.LoginRequest;
import com.mycompany.kitabonline.util.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;

    public TokenResponseDto login(LoginRequest loginRequest) {

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            return TokenResponseDto.builder()
                    .accessToken(tokenGenerator.generateToken(auth))
                    .userDto(userService.getUser(loginRequest.getUsername()))
                    .build();
        } catch (Exception exception) {
            throw GenericException.builder()
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .errorMessage("User not found !")
                    .build();
        }

    }
}
