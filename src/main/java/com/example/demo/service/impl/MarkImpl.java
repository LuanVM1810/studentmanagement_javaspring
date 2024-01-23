package com.example.demo.service.impl;

import com.example.demo.converter.MarkConverter;
import com.example.demo.converter.StudentConverter;
import com.example.demo.dto.MarksDTO;
import com.example.demo.entity.Mark;
import com.example.demo.entity.Student;
import com.example.demo.repository.MarkRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarkImpl implements MarkService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MarkConverter markConverter;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    MarkRepository markRepository;

    @Override
    public boolean createMark(MarksDTO marksDTO) {
        try{
            Mark mark = new Mark();
            mark.setStudent(studentRepository.findStudentByMSSV(marksDTO.getStudentMSSV()));
            mark.setSubject(subjectRepository.findSubjectByCourse(marksDTO.getSubjectCourse()));
            mark.setMark(marksDTO.getMark());
            markRepository.save(mark);
            return true;
        }
        catch(DataIntegrityViolationException e){
            e.printStackTrace();
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateMark(MarksDTO marksDTO, int id) {
        Mark fromDB = markRepository.findById(id).orElse(null);
        if(fromDB == null)
            return false;
        fromDB.setMark(marksDTO.getMark());
        fromDB.setStudent(studentRepository.findStudentByMSSV(marksDTO.getStudentMSSV()));
        fromDB.setSubject(subjectRepository.findSubjectByCourse(marksDTO.getSubjectCourse()));
        markRepository.save(fromDB);
        return true;
    }

    @Override
    public boolean deleteMark(int id) {
        Mark fromDB = markRepository.findById(id).orElse(null);
        if(fromDB == null)
            return false;
        markRepository.deleteById(id);
        return true;
    }

    @Override
    public List<MarksDTO> getStudentandMarkByCourse(String course) {
        List<Mark> markList = markRepository.getStudentWithMarkByCourse(course);
        return markConverter.convertToMarksDTOList(markList);
    }
}
