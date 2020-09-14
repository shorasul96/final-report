package com.shorasul996.web.controllers;


import com.shorasul996.core.dto.AuthenticationRequest;
import com.shorasul996.web.config.MyUserDetailsService;
import com.shorasul996.web.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;


    @PostMapping("admin/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest auth) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getUsername());
        final String jwt = jwtUtils.generateToken(userDetails);

        HashMap<String, Object> token = new HashMap<String, Object>() {{
            put("token", jwt);
            put("id", userDetailsService.getId(auth.getUsername()).getId());
        }};
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

}