package com.alexandersaul.rrhh_project.controller;
import com.alexandersaul.rrhh_project.constants.ContractConstants;
import com.alexandersaul.rrhh_project.dto.contract.ContractRegisterDto;
import com.alexandersaul.rrhh_project.dto.contract.ContractResponseDto;
import com.alexandersaul.rrhh_project.dto.contract.ContractUpdateDto;
import com.alexandersaul.rrhh_project.dto.response.ResponseDto;
import com.alexandersaul.rrhh_project.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @GetMapping("/by-employee")
    public ResponseEntity<List<ContractResponseDto>> getContractByEmployeeId (@RequestParam Integer employeeId){
        List<ContractResponseDto> contractResponseDtos = contractService.getContractsByEmployeeId(employeeId);
        return ResponseEntity.ok()
                .body(contractResponseDtos);
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<ContractResponseDto>> getContractsPaginated (
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size){

        Page<ContractResponseDto> contractResponseDtos = contractService.getContractsPaginated(page, size);

        return ResponseEntity.ok()
                .body(contractResponseDtos);
    }


    @PostMapping
    public ResponseEntity<ResponseDto> createContract (@RequestBody ContractRegisterDto contractRegisterDto){
        contractService.registerContract(contractRegisterDto);
        return ResponseEntity.ok()
                .body(new ResponseDto(ContractConstants.STATUS_201 , ContractConstants.MESSAGE_201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateContract (@PathVariable Integer id, @RequestBody ContractUpdateDto contractUpdateDto){
        contractService.updateContract(id , contractUpdateDto);
        return ResponseEntity.ok()
                .body(new ResponseDto(ContractConstants.STATUS_200 , ContractConstants.MESSAGE_200_UPDATED));
    }

    @PutMapping("/{id}/disable")
    public ResponseEntity<ResponseDto> disableContract (@PathVariable Integer id){
        contractService.disableContract(id);
        return ResponseEntity.ok()
                .body(new ResponseDto(ContractConstants.STATUS_200 , ContractConstants.MESSAGE_200_DISABLED));
    }


}
