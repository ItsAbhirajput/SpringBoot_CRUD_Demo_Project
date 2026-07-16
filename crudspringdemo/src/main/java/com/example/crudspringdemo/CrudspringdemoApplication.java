package com.example.crudspringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ---------------------------------------------------------
 * CRUD Spring Boot Application
 * ---------------------------------------------------------
 * This is the main entry point of the application.
 *
 * Responsibilities:
 * 1. Bootstrap the Spring Boot application.
 * 2. Start the embedded web server (Tomcat by default).
 * 3. Load all Spring Beans and application configuration.
 * 4. Initialize the Spring Application Context.
 * ---------------------------------------------------------
 */
@SpringBootApplication
public class CrudspringdemoApplication {

    /**
     * Main method executed when the application starts.
     *
     * @param args Command-line arguments passed during startup.
     */
    public static void main(String[] args) {

        // Start the Spring Boot application
        SpringApplication.run(CrudspringdemoApplication.class, args);

        // Application started successfully
        System.out.println("Spring Boot CRUD Application Started Successfully.");
    }
}