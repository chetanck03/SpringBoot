package com.restApis.RestApis.repository;

import com.restApis.RestApis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * StudentRepository - REPOSITORY layer in MVC architecture
 * Data Access Layer that handles all database operations for Student entity
 * 
 * By extending JpaRepository<Student, Long>, we automatically get:
 * - findAll() - Get all students
 * - findById(Long id) - Find student by ID
 * - save(Student student) - Save/update student
 * - deleteById(Long id) - Delete student by ID
 * - existsById(Long id) - Check if student exists
 * - count() - Count total students
 * - And many more CRUD operations
 */
@Repository  // Marks this interface as a Spring Data repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // JpaRepository provides all basic CRUD operations
    // We can add custom query methods here if needed, for example:
    
    // List<Student> findByName(String name);
    // List<Student> findByEmailContaining(String email);
    // Optional<Student> findByEmail(String email);
    
}
