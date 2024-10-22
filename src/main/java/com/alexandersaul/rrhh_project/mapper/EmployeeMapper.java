package com.alexandersaul.rrhh_project.mapper;

import com.alexandersaul.rrhh_project.dto.employee.EmployeeRegisterDto;
import com.alexandersaul.rrhh_project.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "documentNumber", source ="document.documentNumber" )
    @Mapping(target = "user", ignore = true)
    Employee toEntity(EmployeeRegisterDto employeeRegisterDto);

}
