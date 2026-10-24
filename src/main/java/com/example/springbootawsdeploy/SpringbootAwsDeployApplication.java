package com.example.springbootawsdeploy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringbootAwsDeployApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsDeployApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("sakthi").isEmpty()) {
                User user = new User();
                user.setUsername("sakthi");
                user.setPassword(passwordEncoder.encode("AWS@123"));
                userRepository.save(user);
            }
        };
    }
}
