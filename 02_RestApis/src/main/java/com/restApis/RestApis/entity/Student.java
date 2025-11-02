package com.restApis.RestApis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Student Entity - Represents the 'student' table in PostgreSQL database
 * This is the MODEL layer in MVC architecture
 */
@Entity  // Marks this class as a JPA entity (database table)
@Getter  // Lombok: Generates getter methods for all fields
@Setter  // Lombok: Generates setter methods for all fields
public class Student {

    @Id  // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;

    private String name;    

    private String email;   
}
