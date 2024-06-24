package com.bh.hhplus_week_02.datasource.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name="Lectures")
public class Lectures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="lectureId")
    private Long lectureId;

    @Column(name="lectureName")
    private String lectureName;

    @Column(name = "studentNum")
    private int studentNum;

    @Column(name = "lectureDate")
    private LocalDateTime lectureDate;
}
