package com.sliu.JPADemo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@Table(name = "subject")
@DynamicUpdate
public class SubjectEntity {

    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String subjectId;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "subject_status")
    private String subjectStatus;

}
