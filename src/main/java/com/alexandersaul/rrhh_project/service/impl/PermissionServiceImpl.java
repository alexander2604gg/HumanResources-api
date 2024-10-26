package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.dto.permission.PermissionRegisterDto;
import com.alexandersaul.rrhh_project.dto.permission.PermissionResponseDto;
import com.alexandersaul.rrhh_project.dto.permission.PermissionUpdateDto;
import com.alexandersaul.rrhh_project.exception.ResourceNotFoundException;
import com.alexandersaul.rrhh_project.mapper.PermissionMapper;
import com.alexandersaul.rrhh_project.model.entity.Employee;
import com.alexandersaul.rrhh_project.model.entity.Permission;
import com.alexandersaul.rrhh_project.repository.PermissionRepository;
import com.alexandersaul.rrhh_project.service.IEmployeeService;
import com.alexandersaul.rrhh_project.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private IEmployeeService employeeService;

    @Override
    public List<PermissionResponseDto> getPermissionsByUserId(Integer userId) {
        Employee employee = employeeService.findEntityByUserId(userId);
        List<Permission> permissions = permissionRepository.findByEmployeeId(employee.getId());
        return permissionMapper.toDtoList(permissions);
    }

    @Override
    public Permission findEntityById(Integer permissionId) {
        return permissionRepository.findById(permissionId).orElseThrow(
                () -> new ResourceNotFoundException("Permission" , "permissionId" , permissionId.toString())
        );
    }

    @Override
    public void createPermission(PermissionRegisterDto permissionRegisterDto) {
        Permission permission = permissionMapper.toEntity(permissionRegisterDto);
        permission.setEmployee(employeeService.findEntityByUserId(permissionRegisterDto.getUserId()));
        permissionRepository.save(permission);
    }

    @Override
    public void updatePermission(Integer permissionId , PermissionUpdateDto permissionUpdateDto) {
        Permission permission = findEntityById(permissionId);
        permission.setStartDate(permissionUpdateDto.getStartDate());
        permission.setEndDate(permissionUpdateDto.getEndDate());
        permission.setPermissionPath(permission.getPermissionPath());
        permission.setPermissionType(permissionUpdateDto.getPermissionType());
        permission.setDescription(permissionUpdateDto.getDescription());
        permissionRepository.save(permission);
    }


    @Override
    public void deletePermission(Integer permissionId) {
        Permission permission = findEntityById(permissionId);
        permissionRepository.delete(permission);
    }

}
