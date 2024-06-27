package com.bh.hhplus_week_02.datasource.repository;

import com.bh.hhplus_week_02.datasource.entity.Lecture;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long>{
    List<Lecture> findAll();
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Lecture findByLectureId(Long lectureId);
}
