package com.syphan.practice.registrationservice.security;

import com.syphan.practice.commonservice.security.BaseSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class RegistrationSecurityConfig extends BaseSecurityConfig {
    @Autowired
    private Environment environment;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
                "/api/v1/auth/sign-in",
                String.format("%s%s", environment.getProperty("spring.boot.admin.context-path", "/registration-service"), "/**")
        ).permitAll();
        super.configure(http);
    }
}
