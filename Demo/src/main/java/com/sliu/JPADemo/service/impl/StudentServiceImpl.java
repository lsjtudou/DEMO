package com.sliu.JPADemo.service.impl;

import com.sliu.JPADemo.dao.StudentRepository;
import com.sliu.JPADemo.entity.StudentEntity;
import com.sliu.JPADemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void insertStudent() {
        studentRepository.save(new StudentEntity());
    }


}
