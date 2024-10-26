package com.alexandersaul.rrhh_project.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBasicInfoDto {
    private Integer userId;
    private String userName;
}
