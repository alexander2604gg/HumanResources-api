package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.dto.employee.EmployeeRegisterDto;
import com.alexandersaul.rrhh_project.dto.employee.EmployeeResponseDto;
import com.alexandersaul.rrhh_project.dto.employee.EmployeeUpdateDto;
import com.alexandersaul.rrhh_project.exception.ResourceNotFoundException;
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
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
    @Lazy
    private IUserService userService;


    @Override
    public Page<EmployeeResponseDto> getEmployeesPaginated(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        List<EmployeeResponseDto> employeeDtos = employeeMapper.toDtoList(employeePage.getContent());


        return new PageImpl<>(employeeDtos, pageable, employeePage.getTotalElements());
    }

    @Override
    public Employee findEntityById(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee" , "employeeId" , employeeId.toString())
        );
    }

    @Override
    public String getEmployeeNameByUserId(Integer userId) {
        Optional<Employee> employeeOptional = employeeRepository.findByUserId(userId);
        return employeeOptional.map(employee ->
                String.join(" ",
                        employee.getFirstName(),
                        employee.getMiddleName(),
                        employee.getFirstSurname(),
                        employee.getSecondSurname()
                )
        ).orElse(null);
    }

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
        employee.setActive(true);
        employee.setUser(userSec);
        userSec.setEmployee(employee);

        employeeRepository.save(employee);

    }

    @Override
    public void updateEmployee( Integer employeeId , EmployeeUpdateDto employeeUpdateDto) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new RuntimeException("Empleado no encontrado")
        );
        employee.setNumPhone(employeeUpdateDto.getNumPhone());
        employee.setAddress(employeeUpdateDto.getAddress());

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
