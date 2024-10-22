package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.model.entity.Role;
import com.alexandersaul.rrhh_project.model.enums.RoleName;
import com.alexandersaul.rrhh_project.repository.RoleRepository;
import com.alexandersaul.rrhh_project.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(Integer roleId) {
        return roleRepository.findById(roleId).orElseThrow(
                () -> new RuntimeException("Rol no encontrado")
        );
    }

    @Override
    public Role findByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName).orElseThrow(
                () -> new RuntimeException("Rol no encontrado")
        );
    }
}
