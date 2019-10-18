package com.syphan.practice.registrationservice.repository;

import com.syphan.practice.commonservice.dao.JpaQueryRepository;
import com.syphan.practice.registrationservice.model.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaQueryRepository<Permission, Integer> {
    Permission findByCode(String code);
}
