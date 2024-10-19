package com.alexandersaul.rrhh_project.model.entity;

import com.alexandersaul.rrhh_project.model.enums.Month;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name = "Payrolls")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "worked_days")
    private BigDecimal workedDays;
    @Column(name = "net_salary")
    private BigDecimal netSalary;
    private Month month;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="payroll_reduction" , joinColumns = @JoinColumn(name = "payroll_id") ,
            inverseJoinColumns = @JoinColumn(name="reduction_id"))
    private Set<Reduction> reductions;

}
