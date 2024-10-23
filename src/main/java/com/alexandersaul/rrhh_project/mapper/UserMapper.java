package com.alexandersaul.rrhh_project.mapper;

import com.alexandersaul.rrhh_project.dto.admin.AdminRegisterDto;
import com.alexandersaul.rrhh_project.model.entity.UserSec;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "rolesList", ignore = true)
    UserSec toEntity (AdminRegisterDto adminRegisterDto);
}
