package com.syphan.practice.registrationservice.config;

import com.syphan.practice.registrationservice.security.JwtTokenProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JwtTokenProperties.class)
public class JwtSecurityAutoConfiguration {

}
