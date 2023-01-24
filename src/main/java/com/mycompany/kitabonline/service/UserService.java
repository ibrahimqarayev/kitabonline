package com.mycompany.kitabonline.service;

import com.mycompany.kitabonline.dto.UserDto;
import com.mycompany.kitabonline.entity.User;
import com.mycompany.kitabonline.exception.GenericException;
import com.mycompany.kitabonline.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        return UserDto.builder()
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }

    public UserDto getUser(String username) {
        User savedUser = userRepository.findByUsername(username).orElseThrow();
        return UserDto.builder()
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> GenericException.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .errorMessage("User not found by given id !")
                .build());
    }

}
