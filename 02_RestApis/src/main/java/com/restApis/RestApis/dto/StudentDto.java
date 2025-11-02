package com.restApis.RestApis.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * StudentDto - Data Transfer Object for returning student data
 * Used for outgoing responses (GET requests) - includes ID
 * Separates internal entity structure from API response format
 */
@Data  // Lombok: Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor  // Lombok: Generates constructor with all fields
@NoArgsConstructor   // Lombok: Generates no-argument constructor
public class StudentDto {
    private long id;      
    private String name;  
    private String email; 
}
