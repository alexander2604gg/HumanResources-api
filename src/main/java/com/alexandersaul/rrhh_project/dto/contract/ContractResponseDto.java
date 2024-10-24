package com.alexandersaul.rrhh_project.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractResponseDto {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private BigDecimal grossSalary;
    private String contractPath;
    private String job;
    private String contractType;
}
