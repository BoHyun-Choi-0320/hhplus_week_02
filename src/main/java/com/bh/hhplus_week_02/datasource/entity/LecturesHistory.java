package com.bh.hhplus_week_02.datasource.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "LecturesHistory")
public class LecturesHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="historyId")
    private Long historyId;

    @Column(name = "userId")
    private Long userId;
    @Column(name="lectureId")
    private Long lectureId;
    @Column(name="registerDate")
    private LocalDateTime registerDate;
}
