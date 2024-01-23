package com.example.demo.controller;

import com.example.demo.dto.MarksDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.SubjectDTO;
import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;
import com.example.demo.service.impl.SubjectImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    SubjectService subjectService;


    @PostMapping("/newsubject")
    public ResponseEntity<?> createNewSubject(@RequestBody SubjectDTO subjectDTO){
        if(subjectService.createNewSubject(subjectDTO) != null)
            return ResponseEntity.status(HttpStatus.OK).body(true);
        return ResponseEntity.status(HttpStatus.OK).body("Create subject fail");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SubjectDTO> updateStudent(@PathVariable int id, @RequestBody SubjectDTO subjectDTO) {
        if(subjectService.updateSubject(subjectDTO,id) != null)
            return new ResponseEntity<>(subjectDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable int id){
        if(subjectService.deleteSubject(id) == true)
            return ResponseEntity.status(HttpStatus.OK).body(true);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Delete student fail");
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> getSubjectByName(@PathVariable String name){
        List<SubjectDTO> subjectDTOList = subjectService.getSubjectsByName(name);
        if(subjectDTOList != null){
            return new ResponseEntity<>(subjectDTOList,HttpStatus.OK);
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");

    }



}
