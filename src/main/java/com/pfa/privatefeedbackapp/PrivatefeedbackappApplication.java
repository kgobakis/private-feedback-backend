package com.pfa.privatefeedbackapp;


import com.pfa.privatefeedbackapp.entities.Role;
import com.pfa.privatefeedbackapp.entities.User;
import com.pfa.privatefeedbackapp.repository.UserRepository;
import com.pfa.privatefeedbackapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

@SpringBootApplication
public class PrivatefeedbackappApplication {



    public static void main(String[] args) {
        SpringApplication.run(PrivatefeedbackappApplication.class, args);
    }

public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {
        builder.userDetailsService(new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                return new CustomUserDetails(userRepository.findByEmail(s));
            }
        });
}

}
