package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.dto.contract.ContractRegisterDto;
import com.alexandersaul.rrhh_project.dto.contract.ContractResponseDto;
import com.alexandersaul.rrhh_project.dto.contract.ContractUpdateDto;
import com.alexandersaul.rrhh_project.dto.contract.EmployeeContractsDto;
import com.alexandersaul.rrhh_project.model.entity.Contract;
import org.springframework.data.domain.Page;

import java.util.List;


public interface IContractService {
    List<ContractResponseDto> getContractsByEmployeeId (Integer employeeId);
    Page<ContractResponseDto> getContractsPaginated (int page , int size);
    EmployeeContractsDto getContractByDocumentNumber (String documentNumber);
    void registerContract (ContractRegisterDto contractRegisterDto);
    void updateContract (Integer contractId , ContractUpdateDto contractUpdateDto);
    Contract findEntityById (Integer contractId);
    void disableContract (Integer contractId);
}
