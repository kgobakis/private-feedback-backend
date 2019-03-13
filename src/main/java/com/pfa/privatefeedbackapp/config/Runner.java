package com.pfa.privatefeedbackapp.config;

import com.pfa.privatefeedbackapp.entities.Role;
import com.pfa.privatefeedbackapp.entities.User;
import com.pfa.privatefeedbackapp.repository.RoleRepository;
import com.pfa.privatefeedbackapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.Collections;

@Configuration
@RequiredArgsConstructor
@Transactional
public class Runner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    ;
    private final BCryptPasswordEncoder BCrypt;

    @Override
    public void run(String... args) throws Exception {
//        Role role = new Role();
//        role.setRole("ADMIN");
//        Role saved = roleRepository.saveAndFlush(role);
//
//        User user = new User();
//        user.setEmail("go@go.com");
//        user.setPassword(BCrypt.encode("password"));
//        user.setName("Andreas");
//        user.setLastName("Gogo");
//        user.setRoles(Collections.singleton(saved));
//
//
//        userRepository.saveAndFlush(user);
    }
}
