package com.sliu.JPADemo.controller;

import com.sliu.JPADemo.service.StudentService;
import com.sliu.JPADemo.utils.UpdateEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    UpdateEventPublisher eventPublisher;

    @RequestMapping(value = "/name")
    public String queryStudent() {
        eventPublisher.publishUpdateEvent("Jeffrey", "Update");
        return "This is Student info:";
    }
}
