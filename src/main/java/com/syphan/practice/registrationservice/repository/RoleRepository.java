package com.syphan.practice.registrationservice.repository;

import com.syphan.practice.commonservice.dao.JpaQueryRepository;
import com.syphan.practice.registrationservice.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaQueryRepository<Role, Integer> {
}
