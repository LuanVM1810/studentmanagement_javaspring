package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.service.impl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> studentDTOList = studentService.getAllStudents();
        if (studentDTOList != null) {
            return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/newstudent")
    public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO){
        if(studentService.createNewStudent(studentDTO) != null)
            return ResponseEntity.status(HttpStatus.OK).body(true);
        return ResponseEntity.status(HttpStatus.OK).body("Create student fail");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        if(studentService.updateStudent(studentDTO,id) != null)
            return new ResponseEntity<>(studentDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        if(studentService.deleteStudent(id) == true)
            return ResponseEntity.status(HttpStatus.OK).body(true);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Delete student fail");
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> getStudentsByName(@PathVariable String name){
        List<StudentDTO> studentDTOList = studentService.getStudentsByName(name);
        if(studentDTOList != null){
            return new ResponseEntity<>(studentDTOList,HttpStatus.OK);
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");

    }



}
