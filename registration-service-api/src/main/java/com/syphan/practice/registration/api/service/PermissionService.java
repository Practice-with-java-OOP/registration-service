package com.syphan.practice.registration.api.service;

import com.syphan.practice.commonservice.exception.BIZException;
import com.syphan.practice.commonservice.service.BaseService;
import com.syphan.practice.dto.registration.PermissionCreateDto;
import com.syphan.practice.registration.api.model.Permission;

public interface PermissionService extends BaseService<Permission, Integer> {

    Permission create(PermissionCreateDto data) throws BIZException;
}
