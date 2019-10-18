package com.syphan.practice.registrationservice.service;

import com.syphan.practice.commonservice.exception.BIZException;
import com.syphan.practice.commonservice.service.BaseService;
import com.syphan.practice.registrationservice.dto.PermissionCreateDto;
import com.syphan.practice.registrationservice.model.Permission;

public interface PermissionService extends BaseService<Permission, Integer> {

    Permission create(PermissionCreateDto data) throws BIZException;
}
