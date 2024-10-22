package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.dto.employee.EmployeeRegisterDto;
import com.alexandersaul.rrhh_project.mapper.EmployeeMapper;
import com.alexandersaul.rrhh_project.model.entity.DocumentType;
import com.alexandersaul.rrhh_project.model.entity.Employee;
import com.alexandersaul.rrhh_project.model.entity.Role;
import com.alexandersaul.rrhh_project.model.entity.UserSec;
import com.alexandersaul.rrhh_project.model.enums.RoleName;
import com.alexandersaul.rrhh_project.repository.EmployeeRepository;
import com.alexandersaul.rrhh_project.service.IDocumentTypeService;
import com.alexandersaul.rrhh_project.service.IEmployeeService;
import com.alexandersaul.rrhh_project.service.IRoleService;
import com.alexandersaul.rrhh_project.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IDocumentTypeService documentTypeService;
    @Autowired
    private IUserService userService;


    @Transactional
    @Override
    public void registerEmployee(EmployeeRegisterDto employeeRegisterDto) {

        DocumentType documentType = documentTypeService.findById(employeeRegisterDto.getDocument().getDocumentTypeId());
        Set<Role> roles = assignRoles(employeeRegisterDto.getRoleId());

        UserSec userSec = UserSec.builder()
                .userName(
                        userService.generateEmployeeUsername(
                                employeeRegisterDto.getFirstName(),
                                employeeRegisterDto.getFirstSurname() ,
                                employeeRegisterDto.getDateOfBirth())
                )
                .email(employeeRegisterDto.getEmail())
                .rolesList(roles)
                .active(true)
                .password(encryptPassword(employeeRegisterDto.getDocument().getDocumentNumber()))
                .build();


        Employee employee = employeeMapper.toEntity(employeeRegisterDto);
        employee.setUser(userSec);
        userSec.setEmployee(employee);

        employeeRepository.save(employee);

    }

    @Override
    public Set<Role> assignRoles (Integer roleId) {
        Role role = roleService.findById(roleId);
        Set<Role> roles = new HashSet<>(Set.of(role));
        if (role.getRoleName() == RoleName.RECURSOS_HUMANOS) {
            Role roleColaborador = roleService.findByRoleName(RoleName.COLABORADOR);
            roles.add(roleColaborador);
        }
        return roles;
    }

    @Override
    public String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
