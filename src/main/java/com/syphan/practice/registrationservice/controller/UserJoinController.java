package com.syphan.practice.registrationservice.controller;

import com.syphan.practice.commonservice.util.response.OpenApiWithDataResponse;
import com.syphan.practice.registrationservice.dto.UserCreateDto;
import com.syphan.practice.registrationservice.model.User;
import com.syphan.practice.registrationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/v1/users")
public class UserJoinController {

    @Autowired
    private UserService userService;

    @PostMapping("mail-captcha")
    public ResponseEntity<OpenApiWithDataResponse<String>> mailCaptcha(@NotBlank @Email @RequestParam String email) {
        return ResponseEntity.ok(new OpenApiWithDataResponse<>(userService.sendUserSignUpMailCaptcha(email)));
    }

    @PostMapping
    public ResponseEntity<OpenApiWithDataResponse<User>> signUp(@Valid @RequestBody UserCreateDto userInfo) {
        return ResponseEntity.ok(new OpenApiWithDataResponse<User>(userService.signUp(userInfo)));
    }
}
