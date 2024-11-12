package com.alexandersaul.rrhh_project.mapper;

import com.alexandersaul.rrhh_project.dto.employee.EmployeeInfoDto;
import com.alexandersaul.rrhh_project.dto.employee.EmployeeRegisterDto;
import com.alexandersaul.rrhh_project.dto.employee.EmployeeResponseDto;
import com.alexandersaul.rrhh_project.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "documentNumber", source ="document.documentNumber" )
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "documentType", ignore = true)
    Employee toEntity(EmployeeRegisterDto employeeRegisterDto);
    @Mapping(target = "fullName", expression = "java(employee.getFirstName() + ' ' + employee.getMiddleName() + ' ' + employee.getFirstSurname() + ' ' + employee.getSecondSurname())")
    EmployeeResponseDto toDto(Employee employee);
    List<EmployeeResponseDto> toDtoList(List<Employee> employees);
    @Mapping(target = "fullName", expression = "java(employee.getFirstName() + ' ' + employee.getMiddleName() + ' ' + employee.getFirstSurname() + ' ' + employee.getSecondSurname())")
    @Mapping(target = "documentType" , source = "documentType.documentName")
    EmployeeInfoDto toDtoInfo (Employee employee);
}
