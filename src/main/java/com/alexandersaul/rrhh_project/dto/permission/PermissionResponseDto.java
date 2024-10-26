package com.alexandersaul.rrhh_project.dto.permission;

import com.alexandersaul.rrhh_project.model.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionResponseDto {

    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private PermissionType permissionType;
    private boolean isAccepted;

}
