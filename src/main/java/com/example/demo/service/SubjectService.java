package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.SubjectDTO;

import java.util.List;

public interface SubjectService {
    SubjectDTO createNewSubject(SubjectDTO subjectDTO);

    SubjectDTO updateSubject(SubjectDTO subjectDTO, int id);

    boolean deleteSubject(int id);

    List<SubjectDTO> getSubjectsByName(String name);
}
