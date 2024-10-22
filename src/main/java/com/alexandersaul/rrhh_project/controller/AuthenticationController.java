package com.alexandersaul.rrhh_project.controller;

import com.alexandersaul.rrhh_project.dto.auth.AuthLoginRequestDto;
import com.alexandersaul.rrhh_project.dto.auth.AuthResponseDto;
import com.alexandersaul.rrhh_project.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login (@RequestBody AuthLoginRequestDto userRequest){
        return new ResponseEntity<>(this.userDetailsService.loginUser(userRequest) , HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        return ResponseEntity.ok().build();
    }
    @PostMapping("/refresh-token")
    public ResponseEntity<Void> refreshToken() {
        return ResponseEntity.ok().build();
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<Void> forgotPassword() {
        return ResponseEntity.ok().build();
    }
    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword() {
        return ResponseEntity.ok().build();
    }

}