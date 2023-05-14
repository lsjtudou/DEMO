package com.sliu.JPADemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
@ToString(exclude = "student")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private String addressId;

    @Column(name = "address_name")
    private String addressName;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private StudentEntity student;
}
