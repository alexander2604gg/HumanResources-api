package com.alexandersaul.rrhh_project.controller;

import com.alexandersaul.rrhh_project.constants.UserConstants;
import com.alexandersaul.rrhh_project.dto.admin.AdminRegisterDto;
import com.alexandersaul.rrhh_project.dto.response.ResponseDto;
import com.alexandersaul.rrhh_project.dto.user.UserBasicInfoDto;
import com.alexandersaul.rrhh_project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/info/{id}")
    public ResponseEntity<UserBasicInfoDto> getBasicInfo(Integer userId) {
        UserBasicInfoDto userBasicInfoDto = userService.getBasicInfo(userId);
        return ResponseEntity.ok()
                .body(userBasicInfoDto);
    }

    @PostMapping("/admins")
    public ResponseEntity<ResponseDto> registerAdmin(@RequestBody AdminRegisterDto adminRegisterDto) {
        userService.registerAdmin(adminRegisterDto);
        return ResponseEntity.ok()
                .body(new ResponseDto(UserConstants.STATUS_201 , UserConstants.MESSAGE_201));
    }

}
