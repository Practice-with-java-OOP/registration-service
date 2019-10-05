package com.syphan.practice.registrationservice.service.impl;

import com.syphan.practice.commonservice.dao.JpaQueryRepository;
import com.syphan.practice.commonservice.service.impl.BaseServiceImpl;
import com.syphan.practice.registrationservice.model.Role;
import com.syphan.practice.registrationservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> implements RoleService {

    @Autowired
    protected RoleServiceImpl(JpaQueryRepository<Role, Integer> repository) {
        super(repository);
    }
}
