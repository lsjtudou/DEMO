package com.sliu.JPADemo.dao;

import com.sliu.JPADemo.entity.SubjectEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SubjectRepositoryTest {

    @Autowired
    SubjectRepository subjectRepository;

    @Test
    public void testFind() {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectId("1");
        List<SubjectEntity> all = subjectRepository.findAll(Example.of(subjectEntity));
        System.out.println(all);
    }

    @Test
    public void testUpdate() {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectId("1");
        subjectEntity.setSubjectName("Chinese");
        subjectRepository.save(subjectEntity);
    }


    @Test
    public void testLit() {
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("sjidj");
        list.add("jeff");
        System.out.println(list.contains("asd"));
    }
}
