package com.sliu.JPADemo.service.impl;

import com.sliu.JPADemo.entity.StudentEntity;
import com.sliu.JPADemo.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceImpl implements RestService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public StudentEntity findByRest(String id) {
        ResponseEntity<StudentEntity> student = restTemplate.getForEntity("http://localhost:8080/student/3", StudentEntity.class);

        return student.getBody();
    }
}
