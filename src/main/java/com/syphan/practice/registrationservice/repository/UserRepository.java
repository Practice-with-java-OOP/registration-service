package com.syphan.practice.registrationservice.repository;

import com.syphan.practice.commonservice.dao.JpaQueryRepository;
import com.syphan.practice.registrationservice.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaQueryRepository<User, Integer> {
    User findByUsername(String username);

    User findByEmail(String email);

    User findByPhoneNum(String phoneNum);
}
