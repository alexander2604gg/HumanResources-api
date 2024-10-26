package com.alexandersaul.rrhh_project.service.impl;

import com.alexandersaul.rrhh_project.dto.auth.AuthLoginRequestDto;
import com.alexandersaul.rrhh_project.dto.auth.AuthResponseDto;
import com.alexandersaul.rrhh_project.model.entity.UserSec;
import com.alexandersaul.rrhh_project.repository.UserSecRepository;
import com.alexandersaul.rrhh_project.security.CustomUserDetails;
import com.alexandersaul.rrhh_project.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserSecRepository userRepository;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserSec userSec = userRepository.findUserSecByUserName((userName)).
                orElseThrow(()->new UsernameNotFoundException(userName + " was not found"));

        Set<GrantedAuthority> authorityList = new HashSet<>();

        userSec.getRolesList()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleName().toString()))));

        userSec.getRolesList().stream()
                .flatMap(role-> role.getViews().stream())
                .forEach(view -> authorityList.add(new SimpleGrantedAuthority(view.getViewName().toString())));


        return new CustomUserDetails( userSec.getId() , userSec.getPassword() ,
                userSec.isActive() , authorityList);
    }

    public AuthResponseDto loginUser (AuthLoginRequestDto authLoginRequestDTO) {
        String username = authLoginRequestDTO.getUserName();
        String password = authLoginRequestDTO.getPassword();

        Authentication authentication = this.authenticate(username,password);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtUtils.createToken(authentication);
        return new AuthResponseDto(username , accessToken);
    }

    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("invalid username or password");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("invalid username or password");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }


}