package com.example.btvn_day_3;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BtvnDay3Application {

    public static void main(String[] args) {
        SpringApplication.run(BtvnDay3Application.class, args);
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }

}
