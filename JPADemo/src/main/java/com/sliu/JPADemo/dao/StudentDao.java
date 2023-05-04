package com.sliu.JPADemo.dao;

import com.sliu.JPADemo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<StudentEntity, String> {

    @Query(value = "update StudentEntity set studentAge = :age where studentName = :name")
    int updateStudent(String name,String age);

    List<StudentEntity> findByStudentName(String name);


}
