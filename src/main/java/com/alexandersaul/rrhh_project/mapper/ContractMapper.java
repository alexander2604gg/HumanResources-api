package com.alexandersaul.rrhh_project.mapper;

import com.alexandersaul.rrhh_project.dto.contract.ContractRegisterDto;
import com.alexandersaul.rrhh_project.dto.contract.ContractResponseDto;
import com.alexandersaul.rrhh_project.model.entity.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "renewals", ignore = true)
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "job", ignore = true)
    @Mapping(target = "contractType", ignore = true)
    Contract toEntity (ContractRegisterDto contractRegisterDto);
    @Mapping(target = "contractType", source = "contractType.contractName")
    @Mapping(target = "job", source = "job.jobName")
    ContractResponseDto ToDto (Contract contract);
    List<ContractResponseDto> toDtoList (List<Contract> contractList);
}
