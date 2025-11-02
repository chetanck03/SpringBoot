package com.restApis.RestApis.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * AddStudentDto - Data Transfer Object for creating/updating students
 * Used for incoming requests (POST/PUT) - excludes ID since it's auto-generated
 * Contains validation rules to ensure data integrity
 */
@Data  // Lombok: Generates getters, setters, toString, equals, hashCode
public class AddStudentDto {
    
    @NotBlank(message = "Name is required")  
    @Size(min = 3, max = 30, message = "Name should be between 3 to 30 characters")
    private String name;

    @Email(message = "Please provide a valid email address")  
    @NotBlank(message = "Email is required") 
    private String email;
}
