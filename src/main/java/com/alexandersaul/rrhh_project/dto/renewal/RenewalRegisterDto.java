package com.alexandersaul.rrhh_project.dto.renewal;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RenewalRegisterDto {

    @FutureOrPresent(message = "La fecha de inicio no debe ser en el pasado")
    private Date startDate;
    @Future(message = "La fecha de fin no debe ser en el pasado")
    private Date endDate;
    @NotNull(message = "El salario bruto es obligatorio")
    private BigDecimal newSalary;
    private String renewalPath;

}
