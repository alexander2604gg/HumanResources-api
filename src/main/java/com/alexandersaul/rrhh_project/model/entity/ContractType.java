package com.alexandersaul.rrhh_project.model.entity;

import com.alexandersaul.rrhh_project.model.enums.ContractName;
import com.alexandersaul.rrhh_project.model.enums.DocumentName;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Contract_types")
public class ContractType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
        @Enumerated(EnumType.STRING)
    private ContractName contractName;

}
