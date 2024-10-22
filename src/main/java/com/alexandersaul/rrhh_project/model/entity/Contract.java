package com.alexandersaul.rrhh_project.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "Contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "start_date")
    private Date startDate;
    @Column (name = "end_date")
    private Date endDate;
    @Column (name = "gross_salary")
    private BigDecimal grossSalary;
    @Column (name = "contract_path")
    private String contractPath;
    @ManyToOne( fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "job_id", nullable = false)
    private Job job ;
    private boolean active;
    @ManyToOne( fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @ManyToOne( fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "contract_type_id", nullable = false)
    private ContractType contractType;
    @OneToMany( fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Renewal> renewals;
}
