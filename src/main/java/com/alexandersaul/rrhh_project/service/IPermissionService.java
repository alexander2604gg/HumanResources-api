package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.dto.permission.PermissionRegisterDto;
import com.alexandersaul.rrhh_project.dto.permission.PermissionResponseDto;
import com.alexandersaul.rrhh_project.dto.permission.PermissionUpdateDto;
import com.alexandersaul.rrhh_project.model.entity.Permission;

import java.util.List;

public interface IPermissionService {

    List<PermissionResponseDto> getPermissionsByUserId(Integer userId);
    Permission findEntityById (Integer permissionId);
    void createPermission (PermissionRegisterDto permissionRegisterDto);
    void updatePermission (Integer permissionId  , PermissionUpdateDto permissionUpdateDto);
    void deletePermission (Integer permissionId);
}
