package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.dto.renewal.RenewalRegisterDto;
import com.alexandersaul.rrhh_project.dto.renewal.RenewalResponseDto;
import com.alexandersaul.rrhh_project.mapper.RenewalMapper;
import com.alexandersaul.rrhh_project.model.entity.Contract;
import com.alexandersaul.rrhh_project.model.entity.Renewal;
import com.alexandersaul.rrhh_project.repository.RenewalRepository;
import com.alexandersaul.rrhh_project.service.IContractService;
import com.alexandersaul.rrhh_project.service.IRenewalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RenewalServiceImpl implements IRenewalService {

    @Autowired
    private RenewalRepository renewalRepository;
    @Autowired
    private IContractService contractService;
    @Autowired
    private RenewalMapper renewalMapper;

    public Renewal getRenewalEntity (Integer renewalId) {
        return null;
    }

    @Override
    public List<RenewalResponseDto> getRenewalsByContractId(Integer contractId) {
        List<Renewal> renewalList = renewalRepository.findByContractId(contractId);
        return renewalMapper.toDtoList(renewalList);
    }

    @Transactional
    @Override
    public void registerRenewal(Integer contractId , RenewalRegisterDto renewalRegisterDto) {
        Renewal renewal = renewalMapper.toEntity(renewalRegisterDto);
        Contract contract = contractService.findEntityById(contractId);
        renewal.setContract(contract);
        renewalRepository.save(renewal);
    }

    public void disabledRenewal (Integer renewalId) {

    }

}
