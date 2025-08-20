package com.nelioalves.workshop_springboot3_jpa.config;

import com.nelioalves.workshop_springboot3_jpa.entities.Category;
import com.nelioalves.workshop_springboot3_jpa.entities.Order;
import com.nelioalves.workshop_springboot3_jpa.entities.Product;
import com.nelioalves.workshop_springboot3_jpa.entities.User;
import com.nelioalves.workshop_springboot3_jpa.entities.enums.OrderStatus;
import com.nelioalves.workshop_springboot3_jpa.repositories.CategoryRepository;
import com.nelioalves.workshop_springboot3_jpa.repositories.OrderRepository;
import com.nelioalves.workshop_springboot3_jpa.repositories.ProductRepository;
import com.nelioalves.workshop_springboot3_jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;



    public void run(String... args ) throws Exception{

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        p2.getCategories().add(cat1);
        cat1.getProducts().add(p2);

        p2.getCategories().add(cat3);
        cat3.getProducts().add(p2);

        p3.getCategories().add(cat3);
        cat3.getProducts().add(p3);

        p4.getCategories().add(cat3);
        cat3.getProducts().add(p4);

        p5.getCategories().add(cat2);
        cat2.getProducts().add(p5);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));


        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));



        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }

}
