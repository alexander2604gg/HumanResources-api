package com.alexandersaul.rrhh_project.mapper;

import com.alexandersaul.rrhh_project.dto.permission.PermissionRegisterDto;
import com.alexandersaul.rrhh_project.dto.permission.PermissionResponseDto;
import com.alexandersaul.rrhh_project.model.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    Permission toEntity (PermissionRegisterDto permissionRegisterDto );
    @Mapping(target = "accepted", ignore = true)
    PermissionResponseDto toDto (Permission permission);
    List<PermissionResponseDto> toDtoList (List<Permission> permissions);

}
