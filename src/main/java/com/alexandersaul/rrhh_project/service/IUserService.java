package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.dto.admin.AdminRegisterDto;

import java.time.LocalDate;
import java.util.Date;

public interface IUserService {
    void registerAdmin (AdminRegisterDto adminRegisterDto);
    String generateEmployeeUsername (String firstName, String firstSurname , LocalDate dateOfBirth);
    String encryptPassword(String password);
}
