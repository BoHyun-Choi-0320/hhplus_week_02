package com.bh.hhplus_week_02.business.dto;

import java.time.LocalDateTime;

public record LectureHistoryDto( Long userId, Long lectureId, LocalDateTime registerDate) {

    public LectureHistoryDto( Long userId, Long lectureId, LocalDateTime registerDate) {
        this.userId = userId;
        this.lectureId = lectureId;
        this.registerDate = registerDate;
    }

    public LectureHistoryDto(Long userId, Long lectureId) {
        this(userId, lectureId, null);
    }
}
