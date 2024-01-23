package com.example.demo.dto;

import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarksDTO {
    private int id;
    private double mark;
    private String studentMSSV;
    private String subjectCourse;
}
