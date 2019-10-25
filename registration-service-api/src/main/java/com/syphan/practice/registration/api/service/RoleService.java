package com.syphan.practice.registration.api.service;

import com.syphan.practice.commonservice.exception.BIZException;
import com.syphan.practice.commonservice.service.BaseService;
import com.syphan.practice.dto.registration.RoleCreateDto;
import com.syphan.practice.registration.api.model.Role;

public interface RoleService extends BaseService<Role, Integer> {

    Role create(RoleCreateDto data) throws BIZException;
}
