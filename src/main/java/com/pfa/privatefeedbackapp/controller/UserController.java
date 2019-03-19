package com.pfa.privatefeedbackapp.controller;

import com.pfa.privatefeedbackapp.EmailCertificationSender;
import com.pfa.privatefeedbackapp.entities.Role;
import com.pfa.privatefeedbackapp.entities.User;
import com.pfa.privatefeedbackapp.service.RoleService;
import com.pfa.privatefeedbackapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@RestController
public class UserController {


    private final UserService userService;
    private final RoleService roleService;
    private final EmailCertificationSender emailCertificationSender;
//    private final VerificationToken verificationToken;

    private final BCryptPasswordEncoder BCrypt;

    @GetMapping("/users")
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    private User getUser(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    private void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }

    @PostMapping("/users")
    private int saveUser(@RequestBody User user) throws MessagingException {
//        Role role = new Role();
//        for(int i = user.getRolesStringSetUsedForSignUp().length; i < 1; i--){
//            String currentRole = user.getRolesStringSetUsedForSignUp()[i];
//            role.setRole(currentRole);
//            user.setRoles(Collections.singleton(role));
//            roleService.saveOrUpdate(role);
//        }
//
//        user.setPassword(BCrypt.encode(user.getPassword()));
        int verificationToken = generateToken();
        user.setVerificationNumber(verificationToken);
        userService.saveOrUpdate(user);
        emailCertificationSender.send(user.getEmail(), "Welcome to our site!", Integer.toString(verificationToken));
        return user.getId();
    }
    public int generateToken(){
        Random random = new Random();
        int max = 999999;
        int min = 111111;
        int randomNumber = random.nextInt((max - min) + min);
        return randomNumber;
    }

}

