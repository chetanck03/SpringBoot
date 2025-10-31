package com.intro.cktechhub;

import org.springframework.stereotype.Component;

/**
 * RazorPay Payment Service Class
 * 
 * This class handles payment processing using RazorPay.
 * @Component tells Spring to manage this class as a Bean (object).
 */
@Component  // This makes Spring create and manage this object automatically
public class RazorPay {
    
    /**
     * Process a payment using RazorPay
     * 
     * @return String message confirming payment was processed
     */
    public String pay() {
        // Create payment message
        String paymentMessage = "RazorPay Payment Successful";
        
        // Show payment info in console (for debugging)
        System.out.println("Processing payment through RazorPay: " + paymentMessage);
        
        // Return success message
        return paymentMessage;
    }
}
