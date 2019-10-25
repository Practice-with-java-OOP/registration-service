package com.syphan.practice.registration.api.repository;

import com.syphan.practice.commonservice.dao.JpaQueryRepository;
import com.syphan.practice.registration.api.model.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaQueryRepository<Permission, Integer> {
    Permission findByCode(String code);
}
