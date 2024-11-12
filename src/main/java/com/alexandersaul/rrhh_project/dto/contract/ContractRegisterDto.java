package com.alexandersaul.rrhh_project.dto.contract;

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
public class ContractRegisterDto {

    @NotNull (message = "El empleado es obligatorio")
    private Integer employeeId;
    @FutureOrPresent(message = "La fecha de inicio no debe ser en el pasado")
    private Date startDate;
    @Future(message = "La fecha de fin no debe ser en el pasado")
    private Date endDate;
    @NotNull(message = "El salario bruto es obligatorio")
    private BigDecimal grossSalary;
    private String contractPath;
    @NotNull(message = "El puesto de trabajo es obligatorio")
    private Integer jobId;
    @NotNull(message = "El tipo de contrato es obligatorio")
    private Integer contractTypeId;
}
