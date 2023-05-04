package com.sliu.JPADemo.dao;

import com.sliu.JPADemo.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.List;

@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testFind() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentAge(24);
        Example<StudentEntity> studentPoExample = Example.of(studentEntity);
        List<StudentEntity> all = studentDao.findAll(studentPoExample);
        System.out.println(all);
        List<StudentEntity> jeffrey = studentDao.findByStudentName("Jeffrey");
        System.out.println(jeffrey);
    }

    @Test
    public void testAdd() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentAge(24);
        studentEntity.setStudentName("Jeffrey");
        studentDao.save(studentEntity);
    }

    @Test
    public void testUpdate() {
        int count = studentDao.updateStudent("李四", "30");
        System.out.println(count);
    }

    @Test
    public void testDelete() {
        studentDao.deleteAll();
    }


}
