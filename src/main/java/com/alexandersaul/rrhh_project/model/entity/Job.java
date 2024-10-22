package com.alexandersaul.rrhh_project.model.entity;

import com.alexandersaul.rrhh_project.model.enums.JobName;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private JobName jobName;
}
