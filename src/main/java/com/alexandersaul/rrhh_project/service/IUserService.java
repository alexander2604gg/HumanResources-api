package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.dto.admin.AdminRegisterDto;
import com.alexandersaul.rrhh_project.dto.user.UserBasicInfoDto;
import com.alexandersaul.rrhh_project.model.entity.UserSec;

import java.time.LocalDate;
import java.util.Date;

public interface IUserService {
    UserBasicInfoDto getBasicInfo (Integer userId);
    void registerAdmin (AdminRegisterDto adminRegisterDto);
    UserSec findEntityById (Integer userId);
    String generateEmployeeUsername (String firstName, String firstSurname , LocalDate dateOfBirth);
    String encryptPassword(String password);
}
