package com.example.demo.service.impl;

import com.example.demo.converter.StudentConverter;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentConverter studentConverter;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> studentList = studentRepository.getAllStudent();
        return studentConverter.convertToStudentDTOList(studentList);
    }

    @Override
    public StudentDTO createNewStudent(StudentDTO studentDTO) {
        if(studentDTO.getName() == null || studentDTO.getName().isEmpty())
            return null;
        if(studentDTO.getDob() == null || studentDTO.getDob().toString().isEmpty())
            return null;
        studentRepository.save(studentConverter.toEntity(studentDTO));
        return studentDTO;
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO, int id) {
        Student fromDB = studentRepository.findById(id).orElse(null);
        if(fromDB == null)
            return null;
        fromDB.setMssv(studentDTO.getMssv());
        fromDB.setDob(studentDTO.getDob());
        fromDB.setName(studentDTO.getName());
        studentRepository.save(fromDB);
        return studentConverter.toDTO(fromDB);
    }

    @Override
    public boolean deleteStudent(int id) {
        Student fromDB = studentRepository.findById(id).orElse(null);
        if(fromDB == null)
            return false;
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public List<StudentDTO> getStudentsByName(String name) {
        List<Student> studentList = studentRepository.findStudentsByName(name);
        return studentConverter.convertToStudentDTOList(studentList);
    }

}
