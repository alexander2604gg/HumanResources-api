package com.alexandersaul.rrhh_project.service;

import java.time.LocalDate;
import java.util.Date;

public interface IUserService {
    String generateEmployeeUsername (String firstName, String firstSurname , LocalDate dateOfBirth);
}
