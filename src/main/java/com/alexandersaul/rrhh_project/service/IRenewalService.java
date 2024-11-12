package com.alexandersaul.rrhh_project.service;

import com.alexandersaul.rrhh_project.dto.renewal.RenewalRegisterDto;
import com.alexandersaul.rrhh_project.dto.renewal.RenewalResponseDto;

import java.util.List;

public interface IRenewalService {
    List<RenewalResponseDto> getRenewalsByContractId (Integer contractId);
    void registerRenewal ( Integer contractId , RenewalRegisterDto renewalRegisterDto);
}
