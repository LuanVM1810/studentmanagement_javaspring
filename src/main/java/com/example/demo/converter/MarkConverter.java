package com.example.demo.converter;

import com.example.demo.dto.MarksDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Mark;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarkConverter {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;
    public Mark toEntity(MarksDTO markDTO){
        if(markDTO == null)
            return null;
        Mark entity = new Mark();
        entity.setMark(markDTO.getMark());
        entity.setStudent(studentRepository.findStudentByMSSV(markDTO.getStudentMSSV()));
        entity.setSubject(subjectRepository.findSubjectByCourse(markDTO.getSubjectCourse()));
        return entity;
    }

    public MarksDTO toDTO(Mark mark){
        if(mark == null){
            return null;
        }
        MarksDTO dto = new MarksDTO();
        dto.setMark(mark.getMark());
        dto.setStudentMSSV(mark.getStudent().getMssv());
        dto.setSubjectCourse(mark.getSubject().getCourse());
        return null;
    }

    public List<MarksDTO> convertToMarksDTOList(List<Mark> markList) {
        List<MarksDTO> markDTOList = new ArrayList<>();
        for (Mark markLists : markList) {
            markDTOList.add(toDTO(markLists));
        }
        return markDTOList;
    }
}
