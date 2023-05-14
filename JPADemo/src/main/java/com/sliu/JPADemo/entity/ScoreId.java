package com.sliu.JPADemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ScoreId implements Serializable {

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "subject_id")
    private String subjectId;


}
