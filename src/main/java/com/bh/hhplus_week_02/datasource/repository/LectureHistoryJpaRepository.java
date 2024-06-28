package com.bh.hhplus_week_02.datasource.repository;

import com.bh.hhplus_week_02.business.dto.LectureHistoryDto;
import com.bh.hhplus_week_02.datasource.entity.LectureHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureHistoryJpaRepository extends JpaRepository<LectureHistory, Long> {
    void save(LectureHistoryDto lectureHistoryDto);
    boolean existsByUserIdAndLectureId(Long userId, Long lectureId);
    int countLectureHistoryByLectureId(Long lectureId);
}
