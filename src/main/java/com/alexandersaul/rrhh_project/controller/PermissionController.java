package com.alexandersaul.rrhh_project.controller;

import com.alexandersaul.rrhh_project.constants.PermissionConstants;
import com.alexandersaul.rrhh_project.dto.permission.PermissionRegisterDto;
import com.alexandersaul.rrhh_project.dto.permission.PermissionResponseDto;
import com.alexandersaul.rrhh_project.dto.permission.PermissionUpdateDto;
import com.alexandersaul.rrhh_project.dto.response.ResponseDto;
import com.alexandersaul.rrhh_project.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<PermissionResponseDto>> getPermissionsByUserId (@RequestParam Integer userId) {
        List<PermissionResponseDto> permissionResponseDtos = permissionService.getPermissionsByUserId(userId);
        return ResponseEntity.ok()
                .body(permissionResponseDtos);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> registerPermission (@RequestBody PermissionRegisterDto permissionRegisterDto){
        permissionService.createPermission(permissionRegisterDto);
        return ResponseEntity.ok()
                .body(new ResponseDto(PermissionConstants.STATUS_201 , PermissionConstants.MESSAGE_201));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseDto> updatePermission (@PathVariable Integer permissionId ,
                                                         @RequestBody PermissionUpdateDto permissionUpdateDto){

        permissionService.updatePermission(permissionId , permissionUpdateDto);
        return ResponseEntity.ok()
                .body(new ResponseDto(PermissionConstants.STATUS_200 , PermissionConstants.MESSAGE_200));

    }


}
