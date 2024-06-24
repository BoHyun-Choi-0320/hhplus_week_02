package com.bh.hhplus_week_02.business.dto;

import java.time.LocalDateTime;

public record LecturesDto(Long lectureId, String lectureName, int studentName, LocalDateTime lectureDate) {

    public LecturesDto(Long lectureId, String lectureName, int studentName, LocalDateTime lectureDate) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.studentName = studentName;
        this.lectureDate = lectureDate;
    }
}
