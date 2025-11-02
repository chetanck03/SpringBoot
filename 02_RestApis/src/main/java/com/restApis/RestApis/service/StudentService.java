package com.restApis.RestApis.service;

import com.restApis.RestApis.dto.AddStudentDto;
import com.restApis.RestApis.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentDto addStudentDto);

    void deleteStudentById(Long id);

    StudentDto updateStudentById(Long id, AddStudentDto addStudentDto);

    StudentDto updatePartialStudentById(Long id, Map<String, Object> updates);
}
