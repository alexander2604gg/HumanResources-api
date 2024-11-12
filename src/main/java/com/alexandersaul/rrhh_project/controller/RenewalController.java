package com.alexandersaul.rrhh_project.controller;

import com.alexandersaul.rrhh_project.constants.ContractConstants;
import com.alexandersaul.rrhh_project.dto.renewal.RenewalRegisterDto;
import com.alexandersaul.rrhh_project.dto.renewal.RenewalResponseDto;
import com.alexandersaul.rrhh_project.dto.response.ResponseDto;
import com.alexandersaul.rrhh_project.service.IRenewalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/renewals")
public class RenewalController{

    @Autowired
    private IRenewalService renewalService;

    @GetMapping("/{contractId}")
    public ResponseEntity<List<RenewalResponseDto>> getRenewalsByContractId (@PathVariable Integer contractId) {
        List<RenewalResponseDto> renewalResponseDtos = renewalService.getRenewalsByContractId(contractId);
        return ResponseEntity.ok()
                .body(renewalResponseDtos);
    }

    @PostMapping("/{contractId}")
    public ResponseEntity<ResponseDto> registerRenewal (@PathVariable Integer contractId , @RequestBody @Valid RenewalRegisterDto renewalRegisterDto){
        renewalService.registerRenewal(contractId , renewalRegisterDto);
        return ResponseEntity.ok()
                .body(new ResponseDto(ContractConstants.STATUS_201 , ContractConstants.MESSAGE_201));
    }

}
