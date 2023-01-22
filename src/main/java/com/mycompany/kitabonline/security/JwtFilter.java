package com.mycompany.kitabonline.security;

import com.mycompany.kitabonline.service.UserDetailsServiceImpl;
import com.mycompany.kitabonline.util.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final TokenGenerator tokenGenerator;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = getToken(request);
        String username;
        try {
            if (!token.isBlank()) {
                username = tokenGenerator.verifyJWT(token).getSubject();
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken
                        .setDetails(new WebAuthenticationDetailsSource());
            }
        }

    }

    private String getToken(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith("Bearer ")) {
            return "";
        }
        return header.substring(7);
    }

}
