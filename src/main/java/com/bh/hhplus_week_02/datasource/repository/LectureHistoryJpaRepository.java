package com.bh.hhplus_week_02.datasource.repository;

import com.bh.hhplus_week_02.business.dto.LectureHistoryDto;
import com.bh.hhplus_week_02.datasource.entity.LectureHistory;
import jakarta.persistence.LockModeType;
import org.hibernate.LockMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface LectureHistoryJpaRepository extends JpaRepository<LectureHistory, Long> {

    boolean existsByUserIdAndLectureId(Long userId, Long lectureId);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    int countLectureHistoryByLectureId(Long lectureId);
}
