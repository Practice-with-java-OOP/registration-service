package com.syphan.practice.registrationservice.service.impl;

import com.syphan.practice.commonservice.service.impl.BaseServiceImpl;
import com.syphan.practice.registrationservice.model.Role;
import com.syphan.practice.registrationservice.repository.RoleRepository;
import com.syphan.practice.registrationservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@org.apache.dubbo.config.annotation.Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> implements RoleService {

    private RoleRepository repository;

    @Autowired
    protected RoleServiceImpl(RoleRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
