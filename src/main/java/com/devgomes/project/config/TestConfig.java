package com.devgomes.project.config;

import com.devgomes.project.entities.Category;
import com.devgomes.project.entities.Order;
import com.devgomes.project.entities.Product;
import com.devgomes.project.entities.User;
import com.devgomes.project.entities.enums.OrderStatus;
import com.devgomes.project.repositories.CategoryRepository;
import com.devgomes.project.repositories.OrderRepository;
import com.devgomes.project.repositories.ProductRepository;
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
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        // CATEGORIES MOCKS
        Category cat1 = Category.builder()
                .name("Electronics")
                .build();
        Category cat2 = Category.builder()
                .name("Books")
                .build();

        Category cat3 = Category.builder()
                .name("Computers")
                .build();

        // PRODUCTS MOCKS
        Product p1 = Product.builder()
                .name("The Lord of the Rings")
                .description("Lorem ipsum dolor sit amet")
                .price(130.00).
                imgUrl("")
                .build();

        Product p2 = Product.builder()
                .name("Smart TV")
                .description("Nulla eu imperdiet purus. Maecenas ante.")
                .price(2190.0).
                imgUrl("")
                .build();

        Product p3 = Product.builder()
                .name("Macbook Pro")
                .description("Nam eleifend maximus tortor, at mollis.")
                .price(1250.0).
                imgUrl("")
                .build();

        Product p4 = Product.builder()
                .name("PC Gamer")
                .description("Donec aliquet odio ac rhoncus cursus.")
                .price(1200.0).
                imgUrl("")
                .build();

        Product p5  = Product.builder()
                .name("Rails for Dummies")
                .description("Cras fringilla convallis sem vel faucibus.")
                .price(100.99).
                imgUrl("")
                .build();

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));



        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));



        // USERS MOCKS
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

        // ORDERS MOCK
        Order o1 = Order.builder()
                .moment(Instant.parse("2026-02-05T23:53:07Z"))
                .orderStatus(OrderStatus.DELIVERED.getCode())
                .client(u1)
                .build();

        Order o2 = Order.builder()
                .moment(Instant.parse("2026-02-06T12:42:10Z"))
                .orderStatus(OrderStatus.WAITING_PAYMENT.getCode())
                .client(u2)
                .build();

        Order o3 = Order.builder()
                .moment(Instant.parse("2026-02-06T12:42:10Z"))
                .orderStatus(OrderStatus.PAID.getCode())
                .client(u1)
                .build();

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
