package com.syphan.practice.registrationservice.service.impl;

import com.syphan.practice.commonservice.service.impl.BaseServiceImpl;
import com.syphan.practice.registrationservice.model.Permission;
import com.syphan.practice.registrationservice.repository.PermissionRepository;
import com.syphan.practice.registrationservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@org.apache.dubbo.config.annotation.Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, Integer> implements PermissionService {

    @Autowired
    protected PermissionServiceImpl(PermissionRepository repository) {
        super(repository);
    }
}
