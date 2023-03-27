package com.example.stin;

import com.example.stin.Bank.Account.AccountEntity;
import com.example.stin.Bank.Account.AccountRepository;
import com.example.stin.Users.UserDetails.UserEntity;
import com.example.stin.Users.UserInterface.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StinApplication {

    public static void main(String[] args) {
        SpringApplication.run(StinApplication.class, args);
    }

    @Profile({"dev", "test"})
    @Bean
    CommandLineRunner run(UserRepository userRepository, AccountRepository accountRepository) {
        return args -> {
            userRepository.save(new UserEntity("admin@gmail.com", new BCryptPasswordEncoder().encode("admin"), "admin", "admin", null, null));
            userRepository.save(new UserEntity("justfoxel@gmail.com", new BCryptPasswordEncoder().encode("admin"), "Vladimir", "Stankov", null, null));
            accountRepository.save(new AccountEntity(1L, null, 500.0, 250.0));
            accountRepository.save(new AccountEntity(2L, 1000.0, 500.0, 250.0));
        };
    }
}
