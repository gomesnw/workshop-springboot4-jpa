package com.devgomes.project.config;

import com.devgomes.project.entities.Order;
import com.devgomes.project.entities.User;
import com.devgomes.project.repositories.OrderRepository;
import com.devgomes.project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor

@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;

    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = User.builder()
                .name("Isaque Gomes")
                .email("isaqueg@gmail.com")
                .phone("912999222")
                .password("123456")
                .build();

        User u2 = User.builder()
                .name("Geovani da Silva")
                .email("geovanisilva@gmail.com")
                .phone("9198383838")
                .password("123456")
                .build();

        Order o1 = new Order(null, Instant.parse("2026-02-05T23:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2026-02-06T12:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2026-02-06T13:21:22Z"), u1);


        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
