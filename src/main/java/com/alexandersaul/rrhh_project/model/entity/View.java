package com.alexandersaul.rrhh_project.model.entity;
import com.alexandersaul.rrhh_project.model.enums.ViewName;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Views")
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private ViewName viewName;
}
