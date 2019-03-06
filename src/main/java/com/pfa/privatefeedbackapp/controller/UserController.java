package com.pfa.privatefeedbackapp.controller;

import com.pfa.privatefeedbackapp.entities.Role;
import com.pfa.privatefeedbackapp.entities.User;
import com.pfa.privatefeedbackapp.repository.UserRepository;
import com.pfa.privatefeedbackapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService service;

    @PostMapping(value = "/users")
    public Object makeUser() {

        System.out.printf("Hello ");
        Role role = new Role();
        role.setRole("user");

        User user = User.builder()
                .active(1)
                .email("alfredo@gmail.com")
                .lastName("LasName")
                .name("The awesome")
                .password("password")
                .roles(Collections.singleton(role))
                .build();
        userRepository.save(user);
        return service.loadUserByUsername(user.getEmail());

    }
}
