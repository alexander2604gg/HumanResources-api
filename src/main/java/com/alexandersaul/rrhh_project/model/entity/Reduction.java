package com.alexandersaul.rrhh_project.model.entity;

import com.alexandersaul.rrhh_project.model.enums.CalculationType;
import com.alexandersaul.rrhh_project.model.enums.ReductionType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Reductions")
public class Reduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private CalculationType calculationType;
    @Enumerated(EnumType.STRING)
    private ReductionType reductionType;
}
