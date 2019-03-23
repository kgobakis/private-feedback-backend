package com.pfa.privatefeedbackapp;

import com.pfa.privatefeedbackapp.entities.Role;
import com.pfa.privatefeedbackapp.entities.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CustomUserDetails implements UserDetails {


    private String email;
    private String password;
    Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails (User user){
        this.email = user.getEmail();
        this.password = user.getPassword();

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : user.getRoles())
            authorities.add(new SimpleGrantedAuthority(role.getRole().toUpperCase()));

        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
