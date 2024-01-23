package com.example.demo.repository;

import com.example.demo.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MarkRepository extends JpaRepository<Mark, Integer> {
    @Query(value = "Select m.id, m.mark, m.student_id, m.subject_id from marks m join subject s on m.subject_id = s.id where s.course = ?1", nativeQuery = true)
    List<Mark> getStudentWithMarkByCourse(String course);
}
