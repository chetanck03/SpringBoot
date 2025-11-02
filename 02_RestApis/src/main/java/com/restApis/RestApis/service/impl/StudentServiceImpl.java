package com.restApis.RestApis.service.impl;

import com.restApis.RestApis.dto.AddStudentDto;
import com.restApis.RestApis.dto.StudentDto;
import com.restApis.RestApis.entity.Student;
import com.restApis.RestApis.repository.StudentRepository;
import com.restApis.RestApis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * StudentServiceImpl - SERVICE layer in MVC architecture
 * Contains business logic and coordinates between Controller and Repository
 * Handles data transformation and validation logic
 */
@Service  // Marks this class as a Spring service component
@RequiredArgsConstructor  // Lombok: Creates constructor for final fields
public class StudentServiceImpl implements StudentService {

    // Dependencies injected by Spring
    private final StudentRepository studentRepository;  // Data access layer
    private final ModelMapper modelMapper;              // Object mapping utility

    /**
     * Retrieves all students from database and converts to DTOs
     * Uses Stream API to transform Entity objects to DTO objects
     */
    @Override
    public List<StudentDto> getAllStudents() {
        // Get all students from database
        List<Student> students = studentRepository.findAll();
        
        // Convert List<Student> to List<StudentDto> using Stream API
        return students.stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();
    }

    /**
     * Finds student by ID and converts to DTO
     * Throws exception if student not found
     */
    @Override
    public StudentDto getStudentById(Long id) {
        // Find student or throw exception if not found
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
        
        // Use ModelMapper to convert Entity to DTO
        return modelMapper.map(student, StudentDto.class);
    }

    /**
     * Creates new student from DTO data
     * Converts DTO -> Entity -> saves -> converts back to DTO
     */
    @Override
    public StudentDto createNewStudent(AddStudentDto addStudentDto) {
        // Convert DTO to Entity using ModelMapper
        Student newStudent = modelMapper.map(addStudentDto, Student.class);
        
        // Save to database (ID will be auto-generated)
        Student savedStudent = studentRepository.save(newStudent);
        
        // Convert saved Entity back to DTO for response
        return modelMapper.map(savedStudent, StudentDto.class);
    }

    /**
     * Deletes student by ID
     * First checks if student exists to provide better error message
     */
    @Override
    public void deleteStudentById(Long id) {
        // Check if student exists before attempting deletion
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student does not exist with id: " + id);
        }
        
        // Delete the student
        studentRepository.deleteById(id);
    }

    /**
     * Complete update - replaces all student fields
     * PUT operation: updates entire resource
     */
    @Override
    public StudentDto updateStudentById(Long id, AddStudentDto addStudentDto) {
        // Find existing student
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
        
        // Map new data to existing entity (preserves ID)
        modelMapper.map(addStudentDto, student);
        
        // Save updated entity
        Student updatedStudent = studentRepository.save(student);
        
        // Return as DTO
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

    /**
     * Partial update - updates only specified fields
     * PATCH operation: updates specific fields only
     * Uses Map to allow dynamic field updates
     */
    @Override
    public StudentDto updatePartialStudentById(Long id, Map<String, Object> updates) {
        // Find existing student
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));

        // Iterate through each field to update
        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field '" + field + "' is not supported for updates");
            }
        });
        
        // Save updated entity
        Student savedStudent = studentRepository.save(student);
        
        // Return as DTO
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}
