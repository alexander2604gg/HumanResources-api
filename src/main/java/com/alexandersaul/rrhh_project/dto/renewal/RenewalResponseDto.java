package com.alexandersaul.rrhh_project.dto.renewal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RenewalResponseDto {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private BigDecimal newSalary;
    private String renewalPath;
}
