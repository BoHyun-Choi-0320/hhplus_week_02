package com.bh.hhplus_week_02.datasource.repository;

import com.bh.hhplus_week_02.datasource.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long>{
    List<Lecture> findAll();
    Lecture findByLectureId(Long lectureId);
}
