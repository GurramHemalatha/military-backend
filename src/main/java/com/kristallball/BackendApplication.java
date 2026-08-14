package com.kristallball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    // Commented out to prevent ID sequence conflicts with PostgreSQL:
    // @Bean
    // CommandLineRunner initDatabase(BaseRepository baseRepository) { ... }
}