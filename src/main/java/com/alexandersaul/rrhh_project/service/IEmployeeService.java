package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.dto.employee.EmployeeRegisterDto;

public interface IEmployeeService {

    void registerEmployee (EmployeeRegisterDto employeeRegisterDto);
    String encryptPassword(String password);

}
