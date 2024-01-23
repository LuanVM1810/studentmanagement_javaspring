package com.example.demo.repository;

import com.example.demo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query(value = "SELECT * FROM Subject WHERE name LIKE %?1%", nativeQuery = true)
    List<Subject> findSubjectsByName(String name);

    @Query(value = "SELECT * FROM subject where course = ?1", nativeQuery = true)
    Subject findSubjectByCourse(String course);
}
