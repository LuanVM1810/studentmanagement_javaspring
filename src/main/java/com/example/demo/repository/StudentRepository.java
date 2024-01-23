package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Lấy danh sách học sinh
    @Query(value = "SELECT * FROM Student", nativeQuery = true)
    List<Student> getAllStudent();

    @Query(value = "SELECT * FROM student WHERE name LIKE %?1%", nativeQuery = true)
    List<Student> findStudentsByName(String name);

    @Query(value = "SELECT * FROM student where mssv = ?1", nativeQuery = true)
    Student findStudentByMSSV(String mssv);

}
