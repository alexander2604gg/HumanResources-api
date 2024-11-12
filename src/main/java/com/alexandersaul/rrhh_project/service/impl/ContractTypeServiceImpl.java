package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.exception.ResourceNotFoundException;
import com.alexandersaul.rrhh_project.model.entity.ContractType;
import com.alexandersaul.rrhh_project.repository.ContractTypeRepository;
import com.alexandersaul.rrhh_project.service.IContractTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractTypeServiceImpl implements IContractTypeService {

    @Autowired
    private ContractTypeRepository contractTypeRepository;

    @Override
    public ContractType findEntityById(Integer contractTypeId) {
        return contractTypeRepository.findById(contractTypeId).orElseThrow(
                () -> new ResourceNotFoundException("ContractType" , "contractTypeId" , contractTypeId.toString())
        );
    }
}
