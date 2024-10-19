package com.alexandersaul.rrhh_project.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "Renewals")
public class Renewal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "start_date")
    private Date startDate;
    @Column (name = "end_date")
    private Date endDate;
    @Column (name = "gross_salary")
    private BigDecimal newSalary;
    @Column (name = "renewal_path")
    private String renewalPath;
    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;
}
