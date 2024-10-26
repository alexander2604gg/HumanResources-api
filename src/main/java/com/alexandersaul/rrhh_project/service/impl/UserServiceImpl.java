package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.dto.admin.AdminRegisterDto;
import com.alexandersaul.rrhh_project.dto.user.UserBasicInfoDto;
import com.alexandersaul.rrhh_project.exception.ResourceNotFoundException;
import com.alexandersaul.rrhh_project.mapper.UserMapper;
import com.alexandersaul.rrhh_project.model.entity.Role;
import com.alexandersaul.rrhh_project.model.entity.UserSec;
import com.alexandersaul.rrhh_project.model.enums.RoleName;
import com.alexandersaul.rrhh_project.repository.RoleRepository;
import com.alexandersaul.rrhh_project.repository.UserSecRepository;
import com.alexandersaul.rrhh_project.service.IEmployeeService;
import com.alexandersaul.rrhh_project.service.IRoleService;
import com.alexandersaul.rrhh_project.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserSecRepository userSecRepository;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    @Lazy
    private IEmployeeService employeeService;



    @Override
    public UserBasicInfoDto getBasicInfo(Integer userId) {

        UserSec userSec = this.findEntityById(userId);

        List<String> rolesName = userSec.getRolesList().stream()
                .map(role -> role.getRoleName().toString())
                .collect(Collectors.toList());

        return UserBasicInfoDto.builder()
                .fullName(employeeService.getEmployeeNameByUserId(userId))
                .userName(userSec.getUserName())
                .photoPath(null)
                .roles(rolesName)
                .build();
    }

    @Transactional
    @Override
    public void registerAdmin(AdminRegisterDto adminRegisterDto) {
        UserSec userSec = userMapper.toEntity(adminRegisterDto);
        userSec.setPassword(encryptPassword(adminRegisterDto.getPassword()));
        userSec.setActive(true);

        Role adminRole = roleService.findByRoleName(RoleName.ADMIN);
        userSec.setRolesList(Set.of(adminRole));

        userSecRepository.save(userSec);
    }

    @Override
    public UserSec findEntityById(Integer userId) {
        return userSecRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User" , "userId" , userId.toString())
        );
    }

    @Override
    public String generateEmployeeUsername(String firstName, String firstSurname, LocalDate dateOfBirth) {

        String day = String.format("%02d", dateOfBirth.getDayOfMonth());
        String month = String.format("%02d", dateOfBirth.getMonthValue());

        return firstName.toLowerCase() + firstSurname.toLowerCase() + day + month;
    }

    @Override
    public String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
