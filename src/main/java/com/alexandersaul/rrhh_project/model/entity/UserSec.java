package com.alexandersaul.rrhh_project.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "Users")
public class UserSec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name" , length = 50 , unique = true , nullable = false)
    private String userName;
    @Column(length = 150, unique = true , nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable (name = "user_roles" , joinColumns = @JoinColumn(name = "user_id") ,
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> rolesList;
    @OneToOne(mappedBy = "user")
    private Employee employee;

}
