package com.intro.cktechhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application Class
 * 
 * This is the starting point of our Spring Boot app.
 * It shows different ways to use dependency injection in Spring.
 */
@SpringBootApplication  // This tells Spring this is the main app class
public class CktechhubApplication implements CommandLineRunner {

    /**
     * Main method - This is where the app starts running
     * Spring Boot will start the web server and set up everything automatically
     */
    public static void main(String[] args) {
        SpringApplication.run(CktechhubApplication.class, args);
    }

    // ========== DIFFERENT WAYS TO CREATE AND USE OBJECTS ==========
    
    // METHOD 1: Creating object manually (Old way - not recommended)
    // Problem: We have to manage the object ourselves
    // private RazorPay payment = new RazorPay();

    // METHOD 2: Using Constructor Injection (Good way)
    // Spring creates the object and gives it to us through constructor
    // Beans = Objects that Spring manages for us automatically
    // 
    // private RazorPay payment;
    // 
    // public CktechhubApplication(RazorPay payment) {
    //     this.payment = payment;  // Spring gives us the object here
    // }

    // METHOD 3: Using @Autowired (Easy way - most common)
    // Spring automatically finds and injects the RazorPay object
    @Autowired
    private RazorPay payment;

    /**
     * This method runs automatically after Spring Boot starts up
     * CommandLineRunner makes sure this runs when everything is ready
     */
    @Override
    public void run(String... args) throws Exception {
        // Call the payment method and show the result
        String result = payment.pay();
        System.out.println("Payment completed in main class: " + result);
    }
}
