package com.example.demo.converter;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentConverter {
    public Student toEntity(StudentDTO studentDTO){
        if(studentDTO == null){
            return null;
        }
        Student entity = new Student();
        entity.setId(studentDTO.getId());
        entity.setDob(studentDTO.getDob());
        entity.setName(studentDTO.getName());
        entity.setMssv(studentDTO.getMssv());
        return entity;
    }

    public StudentDTO toDTO(Student student){
        if(student == null){
            return null;
        }
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setDob(student.getDob());
        dto.setName(student.getName());
        dto.setMssv(student.getMssv());
        return dto;
    }

    public List<StudentDTO> convertToStudentDTOList(List<Student> studentList) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student studentLists : studentList) {
            studentDTOList.add(toDTO(studentLists));
        }
        return studentDTOList;
    }
}
