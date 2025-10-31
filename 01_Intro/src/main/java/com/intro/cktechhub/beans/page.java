package com.intro.cktechhub.beans;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Web Page Controller
 * 
 * This class handles web requests and shows web pages to users.
 * @RestController tells Spring this class handles web requests.
 */
@RestController  // This makes this class handle web requests
public class page {

    /**
     * Home Page Handler
     * 
     * When someone visits the website (/) they will see this message.
     * @GetMapping("/") means this method handles GET requests to the home page
     * 
     * @return String message to show on the web page
     */
    @GetMapping("/")  // This handles requests to the home page "/"
    public String homePage() {
        return "Welcome to CK Tech Hub! This is our first Spring Boot application.";
    }
}


