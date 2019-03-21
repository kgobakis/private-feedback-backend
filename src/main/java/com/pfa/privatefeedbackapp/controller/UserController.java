package com.pfa.privatefeedbackapp.controller;

import com.pfa.privatefeedbackapp.EmailCertificationSender;
import com.pfa.privatefeedbackapp.entities.Role;
import com.pfa.privatefeedbackapp.entities.User;
import com.pfa.privatefeedbackapp.service.RoleService;
import com.pfa.privatefeedbackapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.*;

@RequiredArgsConstructor
@RestController
public class UserController {


    private final UserService userService;
    private final RoleService roleService;
    private final EmailCertificationSender emailCertificationSender;
//    private final VerificationToken verificationToken;

    private final BCryptPasswordEncoder BCrypt;

    @GetMapping("/api/login")
    private Object login(@RequestBody User user) {
        // Checking email to see if they exist
        User crossCheckOriginalUser = userService.getUserByEmail(user.getEmail());
        if (crossCheckOriginalUser == null) {
            return new Integer(0);
        }

        //Checking password to see if it matches
        if (!BCrypt.matches(user.getPassword(), crossCheckOriginalUser.getPassword())) {
            return new Integer(1);
        }

        return crossCheckOriginalUser;
    }

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
        int verificationToken = generateToken();
        user.setVerificationNumber(verificationToken); // need to delete once email has been verified
        userService.saveOrUpdate(user);
        emailCertificationSender.send(user.getEmail(), "Welcome to our site!", Integer.toString(verificationToken));
        return user.getId();
    }

    @PostMapping("/users")
    private void updateUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
    }
    public int generateToken(){
        Random random = new Random();
        int max = 999999;
        int min = 111111;
        int randomNumber = random.nextInt((max - min) + min);
        return randomNumber;
    }

}

