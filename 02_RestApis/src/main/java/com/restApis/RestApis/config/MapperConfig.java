package com.restApis.RestApis.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MapperConfig - Configuration class for ModelMapper
 * Creates and configures beans that Spring will manage
 */
@Configuration  // Tells Spring this class contains bean definitions
public class MapperConfig {

    /**
     * Creates ModelMapper bean for object mapping
     * ModelMapper automatically maps fields between objects with same names
     * 
     * Usage examples:
     * - AddStudentDto -> Student (when creating)
     * - Student -> StudentDto (when returning data)
     * 
     * @return ModelMapper instance managed by Spring
     */
    @Bean  // Tells Spring to create and manage this object
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
