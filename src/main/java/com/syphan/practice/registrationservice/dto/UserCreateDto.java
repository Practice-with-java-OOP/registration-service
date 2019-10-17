package com.syphan.practice.registrationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    @NotBlank(message = "username.must.not.be.blank")
    private String username;

    @NotBlank(message = "password.must.not.be.blank")
    private String password;

    private String avatar;

    private String fullName;

    private String email;

    private String phoneNum;

    private List<Integer> roleIds;
}
