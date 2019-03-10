package com.pfa.privatefeedbackapp.service;

import com.pfa.privatefeedbackapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.pfa.privatefeedbackapp.entities.User user = userRepository.findByEmail(username);
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(r -> r.getRole())
                .map(s -> new SimpleGrantedAuthority(s))
                .collect(Collectors.toList());
        UserDetails userDetails = (UserDetails) new User(user.getEmail(), user.getPassword(), authorities);
        return userDetails;
    }
}