package com.sliu.JPADemo.dao;

import com.sliu.JPADemo.bo.StudentSubjectScore;
import com.sliu.JPADemo.entity.ScoreEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ScoreRepositoryTest {

    @Autowired
    ScoreRepository scoreRepository;

    @Test
    public void testFind() {
        List<ScoreEntity> all = scoreRepository.findAll();
        System.out.println(all);
    }

    @Test
    public void testQuery() {
        List<StudentSubjectScore> result = scoreRepository.findScoreByStudentName("Jeff");
        for (StudentSubjectScore studentSubjectScore : result) {
            System.out.println(studentSubjectScore.getStudentName());
            System.out.println(studentSubjectScore.getSubjectName());
            System.out.println(studentSubjectScore.getScore());
        }
    }

    @Test
    public void testNativeQuery() {
        List<StudentSubjectScore> result = scoreRepository.findScoreByNativeStudentName("张安");
        for (StudentSubjectScore studentSubjectScore : result) {
            System.out.println(studentSubjectScore.getStudentName());
            System.out.println(studentSubjectScore.getSubjectName());
            System.out.println(studentSubjectScore.getScore());
        }
    }


}
