package com.alexandersaul.rrhh_project.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

@Getter
@Setter
public class CustomUserDetails extends User {

    private Integer userId;

    public CustomUserDetails(Integer userId, String username, String password, boolean active , Collection<? extends GrantedAuthority> authorities) {
        super(username, password, active, true, true, true, authorities);
        this.userId = userId;
    }

}