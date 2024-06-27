package com.bh.hhplus_week_02.datasource.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "LectureHistory")
@Getter
@ToString
public class LectureHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="historyId")
    private Long historyId;

    @Column(name = "userId")
    private Long userId;
    @Column(name="lectureId")
    private Long lectureId;
    @Column(name="registerDate")
    @CurrentTimestamp
    private LocalDateTime registerDate;

    protected LectureHistory(Long historyId, Long userId, Long lectureId, LocalDateTime registerDate) {
        this.historyId = historyId;
        this.userId = userId;
        this.lectureId = lectureId;
        this.registerDate = registerDate;
    }

    public LectureHistory(Long userId, Long lectureId) {
        this.userId = userId;
        this.lectureId = lectureId;
    }
}
