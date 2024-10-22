package com.alexandersaul.rrhh_project.model.entity;

import com.alexandersaul.rrhh_project.model.enums.DocumentName;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Document_Types")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private DocumentName documentName;

}
