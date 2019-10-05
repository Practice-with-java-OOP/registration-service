package com.syphan.practice.registrationservice.service.impl;

import com.syphan.practice.commonservice.service.impl.BaseServiceImpl;
import com.syphan.practice.registrationservice.model.User;
import com.syphan.practice.registrationservice.repository.UserRepository;
import com.syphan.practice.registrationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
