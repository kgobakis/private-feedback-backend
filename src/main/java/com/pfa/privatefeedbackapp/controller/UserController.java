package com.pfa.privatefeedbackapp.controller;

import com.pfa.privatefeedbackapp.EmailCertificationSender;

import com.pfa.privatefeedbackapp.entities.User;
import com.pfa.privatefeedbackapp.service.RoleService;
import com.pfa.privatefeedbackapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.*;

@RequiredArgsConstructor
//@RestController
@Controller
public class UserController {


    private final UserService userService;
    private final RoleService roleService;
    private final EmailCertificationSender emailCertificationSender;
//    private final VerificationToken verificationToken;

    private final BCryptPasswordEncoder BCrypt;

    @GetMapping("/login")
    private String login() {
        return "login";
    }

    @GetMapping("/users")
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/home")
    private String Home() {
        return "Welcome!";
    }

    @GetMapping("/users/{id}")
    private User getUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    private void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

//    @PostMapping(value = "/users", consumes="application/json")
//    private Long saveUser(@RequestBody User user) throws MessagingException {
//        int verificationToken = generateToken();
//        user.setVerificationNumber(verificationToken); // need to delete once email has been verified
//        userService.saveOrUpdate(user);
//        emailCertificationSender.send(user.getEmail(), "Welcome to our app!", Integer.toString(verificationToken));
//        return user.getId();
//    }
//
//    @PostMapping("/users")
//    private void updateUser(@RequestBody User user) {
//        userService.saveOrUpdate(user);
//    }
//

    public int generateToken(){
        Random random = new Random();
        int max = 999999;
        int min = 111111;
        int randomNumber = random.nextInt((max - min) + min);
        return randomNumber;
    }

}

