package com.example.demo.service;

import com.example.demo.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO createNewStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(StudentDTO studentDTO, int id);

    boolean deleteStudent(int id);

    List<StudentDTO> getStudentsByName(String name);

}
