package com.sliu.JPADemo.controller;

import com.sliu.JPADemo.entity.StudentEntity;
import com.sliu.JPADemo.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

    @Autowired
    private RestService restService;


    @GetMapping(value = "/test/rest/{id}")
    public StudentEntity get(@PathVariable("id") String id) {
        return restService.findByRest(id);
    }
}
