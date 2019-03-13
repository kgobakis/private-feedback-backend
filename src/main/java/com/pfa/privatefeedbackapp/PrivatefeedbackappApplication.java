package com.pfa.privatefeedbackapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrivatefeedbackappApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrivatefeedbackappApplication.class, args);
    }

//	@Bean
//	CommandLineRunner init(StorageService storageService) {
//		return (args) -> {
//			storageService.deleteAll();
//			storageService.init();
//		};
//	}
}
