package com.springsecurityfirstproject.controllers;

import com.springsecurityfirstproject.config.JwtUtils;
import com.springsecurityfirstproject.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class

AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final com.springsecurityfirstproject.dao.userDao userDao;
    private final JwtUtils jwtUtils;
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request){

        new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword());//a retenir
        final UserDetails user= userDao.findUserByEmail(request.getEmail());
        if (user != null){
            final String token=jwtUtils.generateToken(user);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().build();
    }
}
