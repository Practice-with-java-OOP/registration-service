package com.syphan.practice.registrationservice.service;

import com.syphan.practice.commonservice.exception.BIZException;
import com.syphan.practice.commonservice.service.BaseService;
import com.syphan.practice.registrationservice.dto.UserCreateDto;
import com.syphan.practice.registrationservice.model.User;

public interface UserService extends BaseService<User, Integer> {

    String sendUserSignUpMailCaptcha(String email) throws BIZException;

    User signUp(UserCreateDto data) throws BIZException;

    User findByUsername(String username) throws BIZException;
}
