package com.alexandersaul.rrhh_project.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfoDto {

    private String fullName;
    private String numPhone;
    private LocalDate dateOfBirth;
    private String address;
    private String documentType;
    private String documentNumber;

}
