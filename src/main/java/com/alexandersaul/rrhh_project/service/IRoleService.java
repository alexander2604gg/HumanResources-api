package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.model.entity.Role;
import com.alexandersaul.rrhh_project.model.enums.RoleName;

public interface IRoleService {
    Role findById (Integer roleId);
    Role findByRoleName (RoleName roleName);
}
