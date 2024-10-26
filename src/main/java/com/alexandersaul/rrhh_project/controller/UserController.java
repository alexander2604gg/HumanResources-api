package com.alexandersaul.rrhh_project.controller;

import com.alexandersaul.rrhh_project.constants.UserConstants;
import com.alexandersaul.rrhh_project.dto.admin.AdminRegisterDto;
import com.alexandersaul.rrhh_project.dto.response.ResponseDto;
import com.alexandersaul.rrhh_project.dto.user.UserBasicInfoDto;
import com.alexandersaul.rrhh_project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/perfil")
    public ResponseEntity<UserBasicInfoDto> getInfo(Authentication authentication) {
        String username = authentication.getName();
        UserBasicInfoDto userBasicInfoDto = new UserBasicInfoDto(null, username);
        return ResponseEntity.ok(userBasicInfoDto);
    }

    @PostMapping("/admins")
    public ResponseEntity<ResponseDto> registerAdmin(@RequestBody AdminRegisterDto adminRegisterDto) {
        userService.registerAdmin(adminRegisterDto);
        return ResponseEntity.ok()
                .body(new ResponseDto(UserConstants.STATUS_201 , UserConstants.MESSAGE_201));
    }

}
