package com.alexandersaul.rrhh_project.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminRegisterDto {
    private String userName;
    private String email;
    private String password;
}
