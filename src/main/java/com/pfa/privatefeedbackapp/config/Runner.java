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
import java.util.Arrays;
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
        User newUser = new User();
        newUser.setUsername("user");
        newUser.setEmail("user@user.com");
        newUser.setPassword(BCrypt.encode("user123"));
        Role role = new Role();
        role.setRole("USER");
        Role saved = roleRepository.save(role);
//        newUser.setRoles(Arrays.asList(new Role("USER"), new Role("ACTUATOR")));
        newUser.setRoles(Collections.singletonList(saved));

        userRepository.save(newUser);

    }
}
