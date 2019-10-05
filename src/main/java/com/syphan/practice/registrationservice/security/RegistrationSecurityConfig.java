package com.syphan.practice.registrationservice.security;

import com.syphan.practice.commonservice.security.BaseSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class RegistrationSecurityConfig extends BaseSecurityConfig {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
                "/api/v1/auth/sign-in"
        ).permitAll();
        super.configure(http);
    }
}
