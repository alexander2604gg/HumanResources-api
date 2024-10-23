package com.alexandersaul.rrhh_project.dto.contract;

import java.math.BigDecimal;
import java.util.Date;

public class ContractResponseDto {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private BigDecimal grossSalary;
    private String contractPath;
    private String job;
    private String contractType;
}
