package com.sliu.JPADemo.dao;

import com.sliu.JPADemo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

    List<StudentEntity> findByStudentName(String name);

    List<StudentEntity> findByStudentAgeIsBetween(int start, int end);

    List<StudentEntity> findByStudentNameNull();

    @Query(value = "select student from StudentEntity student where (:name is null or student.studentName = :name)")
    List<StudentEntity> findByQueryStudentName(String name);

    @Query(value = "select * from Student s where (:name is null or s.student_name = :name)", nativeQuery = true)
    List<StudentEntity> findByNativeQueryStudentName(String name);


}
