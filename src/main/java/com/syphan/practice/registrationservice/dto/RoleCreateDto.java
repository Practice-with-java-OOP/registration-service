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
public class RoleCreateDto {
    @NotBlank(message = "name.must.not.be.blank")
    private String name;

    @NotBlank(message = "code.must.not.be.blank")
    private String code;

    private List<Integer> permissionIds;
}
