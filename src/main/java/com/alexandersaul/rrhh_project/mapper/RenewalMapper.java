package com.alexandersaul.rrhh_project.mapper;

import com.alexandersaul.rrhh_project.dto.renewal.RenewalRegisterDto;
import com.alexandersaul.rrhh_project.dto.renewal.RenewalResponseDto;
import com.alexandersaul.rrhh_project.model.entity.Renewal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RenewalMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contract", ignore = true)
    Renewal toEntity (RenewalRegisterDto renewalRegisterDto );
    RenewalResponseDto toDto (Renewal renewal);
    List<RenewalResponseDto> toDtoList (List<Renewal> renewalList);
}
