package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.dto.employee.EmployeeRegisterDto;
import com.alexandersaul.rrhh_project.model.entity.Role;

import java.util.Set;

public interface IEmployeeService {

    void registerEmployee (EmployeeRegisterDto employeeRegisterDto);
    Set<Role> assignRoles (Integer roleId);
    String encryptPassword(String password);
}
