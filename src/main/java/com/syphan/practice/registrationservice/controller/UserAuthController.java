package com.syphan.practice.registrationservice.controller;

import com.syphan.practice.commonservice.util.EntityValidationUtils;
import com.syphan.practice.commonservice.util.response.OpenApiWithDataResponse;
import com.syphan.practice.registrationservice.dto.UserSignIn;
import com.syphan.practice.registrationservice.security.JwtTokenProperties;
import com.syphan.practice.registrationservice.security.JwtTokenProvider;
import com.syphan.practice.registrationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class UserAuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProperties jwtProperties;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/sign-in")
    public ResponseEntity<OpenApiWithDataResponse<String>> authenticateUser(@Valid @RequestBody UserSignIn reqParam,
                                                                            BindingResult bindingResult) {
        EntityValidationUtils.processBindingResults(bindingResult);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(reqParam.getUsername(), reqParam.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok(new OpenApiWithDataResponse<>(
                String.format("%s %s", jwtProperties.getTokenPrefix(), jwtTokenProvider.generateToken(authentication))));
    }
}
