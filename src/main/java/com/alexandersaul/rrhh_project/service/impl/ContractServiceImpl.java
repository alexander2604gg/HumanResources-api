package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.dto.contract.ContractRegisterDto;
import com.alexandersaul.rrhh_project.mapper.ContractMapper;
import com.alexandersaul.rrhh_project.model.entity.Contract;
import com.alexandersaul.rrhh_project.repository.ContractRepository;
import com.alexandersaul.rrhh_project.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ContractMapper contractMapper;

    @Override
    public void registerContract(ContractRegisterDto contractRegisterDto) {
        Contract contract = contractMapper.toEntity(contractRegisterDto);
        contract.setActive(true);
        contractRepository.save(contract);
    }


}
