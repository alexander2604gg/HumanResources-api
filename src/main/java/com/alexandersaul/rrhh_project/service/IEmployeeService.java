package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.dto.employee.EmployeeInfoDto;
import com.alexandersaul.rrhh_project.dto.employee.EmployeeRegisterDto;
import com.alexandersaul.rrhh_project.dto.employee.EmployeeResponseDto;
import com.alexandersaul.rrhh_project.dto.employee.EmployeeUpdateDto;
import com.alexandersaul.rrhh_project.model.entity.Employee;
import com.alexandersaul.rrhh_project.model.entity.Role;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface IEmployeeService {

    Page<EmployeeResponseDto> getEmployeesPaginated (int page , int size);
    Employee findEntityByUserId (Integer userId);
    Employee findEntityById (Integer employeeId);
    Employee findEntityByDocumentNumber (String documentNumber);
    EmployeeInfoDto getEmployeeInfoById (Integer employeeId);
    EmployeeInfoDto getEmployeeInfoByUserId (Integer userId);
    EmployeeResponseDto getEmployeeByDocumentNumber (String documentNumber);
    String getEmployeeNameByUserId (Integer userId);
    void registerEmployee (EmployeeRegisterDto employeeRegisterDto);
    void updateEmployeeByUserId (Integer userId , EmployeeUpdateDto employeeUpdateDto);
    void updateEmployee ( Integer employeeId , EmployeeUpdateDto employeeUpdateDto);
    Set<Role> assignRoles (Integer roleId);
    String encryptPassword(String password);
}
