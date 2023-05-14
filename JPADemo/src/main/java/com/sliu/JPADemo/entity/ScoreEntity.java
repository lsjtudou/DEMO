package com.sliu.JPADemo.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student_subject_score")
@ToString(exclude = "student")
public class ScoreEntity {

    @EmbeddedId
    private ScoreId scoreId;

    @Column(name = "score")
    private String score;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @MapsId("studentId")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @MapsId("subjectId")
    private SubjectEntity subjectEntity;


}
