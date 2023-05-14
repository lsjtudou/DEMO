package com.sliu.JPADemo.dao;

import com.sliu.JPADemo.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    public void testFind() {
        List<StudentEntity> students = studentRepository.findByStudentName("Jeff");
        StudentEntity student = students.get(0);
        System.out.println(student);

    }

    @Test
    public void testAdd() {
        List<SubjectEntity> list = subjectRepository.findAll();
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId("");
        studentEntity.setStudentName("Jeff");
        studentEntity.setStudentAge(30);

        ScoreEntity scoreEntity1 = new ScoreEntity();
        scoreEntity1.setScore("70");
        scoreEntity1.setScoreId(new ScoreId());
        scoreEntity1.setStudent(studentEntity);
        scoreEntity1.setSubjectEntity(list.get(0));

        ScoreEntity scoreEntity2 = new ScoreEntity();
        scoreEntity2.setScore("80");
        scoreEntity2.setScoreId(new ScoreId());
        scoreEntity2.setStudent(studentEntity);
        scoreEntity2.setSubjectEntity(list.get(1));

        List<ScoreEntity> scores = new ArrayList<>();
        scores.add(scoreEntity1);
        scores.add(scoreEntity2);

        studentEntity.setScores(scores);

        studentRepository.save(studentEntity);


    }

    @Test
    public void testUpdate() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentAge(10);
        Example<StudentEntity> studentPoExample = Example.of(studentEntity);
        List<StudentEntity> list = studentRepository.findAll(studentPoExample);
        StudentEntity studentEntity1 = list.get(0);

        List<SubjectEntity> list1 = subjectRepository.findAll();
        ScoreEntity scoreEntity1 = new ScoreEntity();
        scoreEntity1.setScore("45");
        scoreEntity1.setScoreId(new ScoreId(studentEntity1.getStudentId(), list1.get(0).getSubjectId()));
        scoreEntity1.setStudent(studentEntity1);
        scoreEntity1.setSubjectEntity(list1.get(0));

        List<ScoreEntity> scores = new ArrayList<>();
        scores.add(scoreEntity1);
        studentEntity1.setScores(scores);
        studentRepository.save(studentEntity1);
    }

    @Test
    public void testUpdateCascade() {
        StudentEntity student = studentRepository.findById("14").get();
        student.getScores().get(0).setScore("45");
        studentRepository.save(student);
    }

    @Test
    public void testFindBetween() {
        List<StudentEntity> student = studentRepository.findByStudentAgeIsBetween(10, 50);
        System.out.println(student);
    }

    @Test
    public void testFindNullName() {
        List<StudentEntity> list = studentRepository.findByStudentNameNull();
        System.out.println(list);
    }

    @Test
    public void testFindByQuery() {
        List<StudentEntity> list = studentRepository.findByQueryStudentName("LIUSHENJIE");
        System.out.println(list);
    }

    @Test
    public void testFindByNativeQuery() {
        List<StudentEntity> list = studentRepository.findByNativeQueryStudentName(null);
        System.out.println(list);
    }

    @Test
    public void testDelete() throws Exception {
        StudentEntity student = studentRepository.findById("31").orElseThrow(Exception::new);
        student.setScores(new ArrayList<>());
        studentRepository.save(student);
    }


}
