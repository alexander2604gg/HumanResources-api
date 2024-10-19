package com.alexandersaul.rrhh_project.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "role_name")
    private String rolName;
    @Lob
    private String description;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="roles_views" , joinColumns = @JoinColumn(name = "role_id") ,
            inverseJoinColumns = @JoinColumn(name="view_id"))
    private Set<View> views;
}