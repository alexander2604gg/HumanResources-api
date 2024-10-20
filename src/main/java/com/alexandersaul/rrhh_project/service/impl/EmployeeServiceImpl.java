package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.dto.employee.EmployeeRegisterDto;
import com.alexandersaul.rrhh_project.mapper.EmployeeMapper;
import com.alexandersaul.rrhh_project.model.entity.DocumentType;
import com.alexandersaul.rrhh_project.model.entity.Employee;
import com.alexandersaul.rrhh_project.model.entity.UserSec;
import com.alexandersaul.rrhh_project.model.enums.DocumentName;
import com.alexandersaul.rrhh_project.repository.DocumentTypeRepository;
import com.alexandersaul.rrhh_project.repository.EmployeeRepository;
import com.alexandersaul.rrhh_project.repository.UserSecRepository;
import com.alexandersaul.rrhh_project.service.IEmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private UserSecRepository userSecRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Transactional
    @Override
    public void registerEmployee(EmployeeRegisterDto employeeRegisterDto) {

        DocumentType documentType = documentTypeRepository.findById(
                employeeRegisterDto.getDocument().getDocumentTypeId())
                .orElseThrow(()-> new RuntimeException("Invalid document")
                );

        UserSec userSec = UserSec.builder()
                .userName(employeeRegisterDto.getFirstName()+employeeRegisterDto.getFirstSurname())
                .email(employeeRegisterDto.getEmail())
                .active(true)
                .password(encryptPassword(employeeRegisterDto.getDocument().getDocumentNumber()))
                .build();

        Employee employee = employeeMapper.toEntity(employeeRegisterDto);
        employee.setUser(userSec);
        userSec.setEmployee(employee);

        employeeRepository.save(employee);

    }

    @Override
    public String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
