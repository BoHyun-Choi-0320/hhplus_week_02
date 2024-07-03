package com.bh.hhplus_week_02.business.dto;

import java.time.LocalDateTime;

public record LectureDto(Long lectureId, String lectureName, int studentNum, LocalDateTime lectureDate) {

    public LectureDto(Long lectureId, String lectureName, int studentNum, LocalDateTime lectureDate) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.studentNum = studentNum;
        this.lectureDate = lectureDate;
    }
}
