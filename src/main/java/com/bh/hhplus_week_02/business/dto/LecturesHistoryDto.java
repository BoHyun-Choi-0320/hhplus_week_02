package com.bh.hhplus_week_02.business.dto;

import java.time.LocalDateTime;

public record LecturesHistoryDto(Long historyId, Long userId, Long lectureId, LocalDateTime registerDate) {

    public LecturesHistoryDto(Long historyId, Long userId, Long lectureId, LocalDateTime registerDate) {
        this.historyId = historyId;
        this.userId = userId;
        this.lectureId = lectureId;
        this.registerDate = registerDate;
    }
}
