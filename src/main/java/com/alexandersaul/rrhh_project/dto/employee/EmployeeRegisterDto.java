package com.alexandersaul.rrhh_project.dto.employee;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRegisterDto {

    @NotBlank(message = "El primer nombre es obligatorio")
    private String firstName;
    private String middleName;
    @NotBlank(message = "El primer apellido es obligatorio")
    private String firstSurname;
    @NotBlank(message = "El segundo apellido es obligatorio")
    private String secondSurname;
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate dateOfBirth;
    @Pattern(regexp = "^\\d{9}$", message = "El número de teléfono debe tener 9 dígitos")
    private String numPhone;
    @Email(message = "El correo electrónico no tiene un formato válido")
    @NotBlank(message = "El correo electrónico es obligatorio")
    private String email;
    @NotBlank(message = "La dirección es obligatoria")
    private String address;
    @NotNull(message = "La información del documento es obligatoria")
    private DocumentInfoDto document;
    @NotNull(message = "El rol es obligatorio")
    private Integer roleId;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DocumentInfoDto {
        @NotNull(message = "El tipo de documento es obligatorio")
        private Integer documentTypeId;
        @Pattern(regexp = "^\\d{8,12}$", message = "El número de documento debe tener entre 8 y 12 dígitos")
        private String documentNumber;
    }
}