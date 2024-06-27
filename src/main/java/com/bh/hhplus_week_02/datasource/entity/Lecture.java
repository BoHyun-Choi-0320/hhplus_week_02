package com.bh.hhplus_week_02.datasource.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name="Lecture")
@Getter
public class Lecture {
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

    public Lecture(Long lectureId, String lectureName, int studentNum, LocalDateTime lectureDate) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.studentNum = studentNum;
        this.lectureDate = lectureDate;
    }

    public Lecture(String lectureName, int studentNum, LocalDateTime lectureDate){
        this.lectureName = lectureName;
        this.studentNum = studentNum;
        this.lectureDate = lectureDate;
    }
}
