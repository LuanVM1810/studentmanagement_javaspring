package com.example.demo.controller;

import com.example.demo.dto.MarksDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/marks")
public class MarkController {
    @Autowired
    MarkService markService;

    @PostMapping("/create")
    public ResponseEntity<?> createMark(@RequestBody MarksDTO marksDTO){
        if(markService.createMark(marksDTO))
            return ResponseEntity.status(HttpStatus.OK).body(true);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Create mark fail");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody MarksDTO marksDTO) {
        if(markService.updateMark(marksDTO,id))
            return ResponseEntity.status(HttpStatus.OK).body("Updated!!");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update fail");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMark(@PathVariable int id){
        if(markService.deleteMark(id) == true)
            return ResponseEntity.status(HttpStatus.OK).body("Student wad deleted!");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Delete student fail");
    }

    @GetMapping("/{course}")
    public ResponseEntity<List<MarksDTO>> getStudentWithMarkBySubject(@PathVariable String course){
        List<MarksDTO> markList = markService.getStudentandMarkByCourse(course);
        if(markList != null)
            return new ResponseEntity<>(markList, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
