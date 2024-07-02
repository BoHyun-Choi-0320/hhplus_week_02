package com.bh.hhplus_week_02.datasource.repositoryImpl;

import com.bh.hhplus_week_02.business.dto.LectureHistoryDto;
import com.bh.hhplus_week_02.business.repository.LectureHistoryRepository;
import com.bh.hhplus_week_02.datasource.entity.LectureHistory;
import com.bh.hhplus_week_02.datasource.repository.LectureHistoryJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LectureHistoryRepositoryImpl implements LectureHistoryRepository {

    private final LectureHistoryJpaRepository lectureHistoryJpaRepository;

    public LectureHistoryRepositoryImpl(LectureHistoryJpaRepository lectureHistoryJpaRepository) {
        this.lectureHistoryJpaRepository = lectureHistoryJpaRepository;
    }

    @Override
    public void save(LectureHistoryDto lectureHistoryDto) {
        LectureHistory lectureHistory = new LectureHistory(lectureHistoryDto.userId(), lectureHistoryDto.lectureId());
        lectureHistoryJpaRepository.save(lectureHistory);
    }

    @Override
    public boolean existsByUserIdAndLectureId(Long userId, Long lectureId) {
        return lectureHistoryJpaRepository.existsByUserIdAndLectureId(userId, lectureId);
    }

    @Override
    public int countLectureHistoryByLectureId(Long lectureId) {
        return lectureHistoryJpaRepository.countLectureHistoryByLectureId(lectureId);
    }
}
