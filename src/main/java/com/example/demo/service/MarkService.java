package com.example.demo.service;

import com.example.demo.dto.MarksDTO;
import com.example.demo.dto.StudentDTO;

import java.util.List;

public interface MarkService {
    boolean createMark(MarksDTO markdto);

    boolean updateMark(MarksDTO marksDTO, int id);

    boolean deleteMark(int id);

    List<MarksDTO> getStudentandMarkByCourse(String course);
}
