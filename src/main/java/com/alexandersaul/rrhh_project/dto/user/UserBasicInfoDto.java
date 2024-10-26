package com.alexandersaul.rrhh_project.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBasicInfoDto {
    private String userName;
    private String fullName;
    private String photoPath;
    private List<String> roles;
}
