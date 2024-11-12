package com.alexandersaul.rrhh_project.dto.contract;

import com.alexandersaul.rrhh_project.dto.employee.EmployeeResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeContractsDto {

    private EmployeeResponseDto employeeResponseDto;
    private List<ContractResponseDto> contractResponseDtoList;

}
