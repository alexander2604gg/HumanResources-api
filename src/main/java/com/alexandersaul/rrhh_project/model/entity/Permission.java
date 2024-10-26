package com.alexandersaul.rrhh_project.model.entity;

import com.alexandersaul.rrhh_project.model.enums.PermissionType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "Permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "start_date")
    private LocalDate startDate;
    @Column (name = "end_date")
    private LocalDate endDate;
    @Column (name = "permission_path")
    private String permissionPath;
    @Enumerated(EnumType.STRING)
    private PermissionType permissionType;
    @Lob
    private String description;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
