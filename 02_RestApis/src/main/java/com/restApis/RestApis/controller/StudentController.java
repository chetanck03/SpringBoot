package com.restApis.RestApis.controller;

import com.restApis.RestApis.dto.AddStudentDto;
import com.restApis.RestApis.dto.StudentDto;
import com.restApis.RestApis.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController  // Combines @Controller + @ResponseBody (returns JSON automatically)
@RequiredArgsConstructor  // Lombok: Creates constructor for final fields ( no need to write constructor objects delcare)
public class StudentController {

    // Dependency injection - Spring automatically provides StudentService implementation
    private final StudentService studentService;

   
    @GetMapping("/")
    public String app(){
        return "Spring Boot Application!";
    }

   
    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

   
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id ){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

  
    @GetMapping("/students/{id}/{name}")
    public String getStudentId(@PathVariable Long id , @PathVariable String name){
        return "Path Variable: "+id+" Name: "+name;
    }

    
    @PostMapping("/students")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentDto addStudentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentDto));
    }

    
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id ){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable Long id, @RequestBody AddStudentDto addStudentDto ){
        return ResponseEntity.ok(studentService.updateStudentById(id,addStudentDto));
    }

   
    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentDto> updatePartialStudentById(@PathVariable Long id, @RequestBody Map<String,Object> updates ){
        return ResponseEntity.ok(studentService.updatePartialStudentById(id,updates));
    }

}
