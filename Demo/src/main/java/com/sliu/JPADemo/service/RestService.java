package com.sliu.JPADemo.service;

import com.sliu.JPADemo.entity.StudentEntity;

public interface RestService {

    StudentEntity findByRest(String id);
}
