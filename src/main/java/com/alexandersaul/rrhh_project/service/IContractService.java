package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.dto.contract.ContractRegisterDto;
import com.alexandersaul.rrhh_project.dto.contract.ContractUpdateDto;
import com.alexandersaul.rrhh_project.model.entity.Contract;
import org.springframework.data.domain.Page;

public interface IContractService {
    void registerContract (ContractRegisterDto contractRegisterDto);
    void updateContract (Integer contractId , ContractUpdateDto contractUpdateDto);
    Contract findEntityById (Integer contractId);
    void disableContract (Integer contractId);
}
