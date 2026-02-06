package com.devgomes.project.config;

import com.devgomes.project.entities.User;
import com.devgomes.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Isaque Gomes", "isaqueg@gmail.com", "912999222", "123456");
        User u2 = new User(null, "Geovani da Silva", "geovanisilva@gmail.com", "9198383838", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
