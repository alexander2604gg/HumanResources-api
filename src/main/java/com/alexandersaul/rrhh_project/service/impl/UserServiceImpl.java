package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.service.IUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public String generateEmployeeUsername(String firstName, String firstSurname, LocalDate dateOfBirth) {

        String day = String.format("%02d", dateOfBirth.getDayOfMonth());
        String month = String.format("%02d", dateOfBirth.getMonthValue());

        return firstName.toLowerCase() + firstSurname.toLowerCase() + day + month;
    }

}
