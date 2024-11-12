package com.alexandersaul.rrhh_project.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name" , length = 30)
    private String firstName;
    @Column(name = "middle_name" , length = 30)
    private String middleName;
    @Column(name = "first_surname" , length = 50)
    private String firstSurname;
    @Column(name = "second_surname" , length = 50)
    private String secondSurname;
    @Column(name = "num_phone" , length = 9)
    private String numPhone;
    private LocalDate dateOfBirth;
    @Column(length = 100)
    private String address;
    @ManyToOne
    @JoinColumn(name = "document_type_id" , referencedColumnName = "id")
    private DocumentType documentType;
    @Column(length = 15 , unique = true)
    private String documentNumber;
    private boolean active;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserSec user;

}
