package com.sliu.JPADemo.dao;

import com.sliu.JPADemo.bo.StudentSubjectScore;
import com.sliu.JPADemo.entity.ScoreEntity;
import com.sliu.JPADemo.entity.ScoreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, ScoreId> {

    @Query("select s.studentName as studentName, sub.subjectName as subjectName,sc.score as score from StudentEntity s, SubjectEntity sub, ScoreEntity sc where s.studentId = sc.scoreId.studentId and sub.subjectId = sc.scoreId.subjectId and :name = s.studentName")
    List<StudentSubjectScore> findScoreByStudentName(String name);

    @Query(value = "select s.student_name as studentName, sub.subject_name as subjectName,sc.score as score from student s, subject sub, student_subject_score sc where s.student_id = sc.student_id and sub.subject_id = sc.subject_id and :name = s.student_name", nativeQuery = true)
    List<StudentSubjectScore> findScoreByNativeStudentName(String name);

}
