package com.example.demo.converter;


import com.example.demo.dto.SubjectDTO;
import com.example.demo.entity.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectConverter {
    public Subject toEntity(SubjectDTO subjectDTO){
        if(subjectDTO == null)
            return null;
        Subject entity = new Subject();
        entity.setId(subjectDTO.getId());
        entity.setName(subjectDTO.getName());
        entity.setCourse(subjectDTO.getCourse());
        return entity;
    }

    public SubjectDTO toDTO(Subject subject){
        if(subject == null)
            return null;
        SubjectDTO dto = new SubjectDTO();
        dto.setId(subject.getId());
        dto.setName(subject.getName());
        dto.setCourse(subject.getCourse());
        return dto;
    }

    public List<SubjectDTO> convertToSubjectDTOList(List<Subject> subjectList) {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        for (Subject subjectLists : subjectList) {
            subjectDTOList.add(toDTO(subjectLists));
        }
        return subjectDTOList;
    }
}
