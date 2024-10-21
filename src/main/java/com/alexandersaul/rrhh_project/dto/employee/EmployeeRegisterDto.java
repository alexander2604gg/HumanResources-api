package com.alexandersaul.rrhh_project.dto.employee;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRegisterDto {
    private String firstName;
    private String middleName;
    private String firstSurname;
    private String secondSurname;
    private String numPhone;
    private String email;
    private String address;
    private DocumentInfoDto document;
    private Integer roleId;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DocumentInfoDto {
        private Integer documentTypeId;
        private String documentNumber;
    }
}