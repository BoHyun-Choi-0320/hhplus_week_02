package com.bh.hhplus_week_02.business.repository;

import com.bh.hhplus_week_02.business.dto.LectureHistoryDto;

public interface LectureHistoryRepository {
    void save(LectureHistoryDto lectureHistoryDto);
    boolean existsByUserIdAndLectureId(Long userId, Long lectureId);
    int countLectureHistoryByLectureId(Long lectureId);
}
