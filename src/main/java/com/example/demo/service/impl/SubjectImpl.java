package com.example.demo.service.impl;

import com.example.demo.converter.SubjectConverter;
import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.SubjectDTO;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SubjectConverter subjectConverter;

    @Override
    public SubjectDTO createNewSubject(SubjectDTO subjectDTO) {
        if(subjectDTO == null)
            return null;
        if(subjectDTO.getCourse() == null || subjectDTO.getCourse().isEmpty())
            return null;
        if(subjectDTO.getName() == null || subjectDTO.getCourse().isEmpty())
            return null;
        subjectRepository.save(subjectConverter.toEntity(subjectDTO));
        return subjectDTO;

    }

    public SubjectDTO updateSubject(SubjectDTO subjectDTO, int id) {
        Subject fromDB = subjectRepository.findById(id).orElse(null);
        if(fromDB == null)
            return null;
        fromDB.setCourse(subjectDTO.getCourse());
        fromDB.setName(subjectDTO.getName());
        subjectRepository.save(fromDB);
        return subjectConverter.toDTO(fromDB);
    }

    public boolean deleteSubject(int id) {
        Subject fromDB = subjectRepository.findById(id).orElse(null);
        if(fromDB == null)
            return false;
        subjectRepository.deleteById(id);
        return true;
    }

    @Override
    public List<SubjectDTO> getSubjectsByName(String name) {
        List<Subject> subjectList = subjectRepository.findSubjectsByName(name);
        return subjectConverter.convertToSubjectDTOList(subjectList);
    }
}
