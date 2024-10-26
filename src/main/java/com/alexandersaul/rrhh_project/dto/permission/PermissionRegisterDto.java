package com.alexandersaul.rrhh_project.dto.permission;

import com.alexandersaul.rrhh_project.model.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionRegisterDto {
    private Integer userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String permissionPath;
    private PermissionType permissionType;
    private String description;
}
