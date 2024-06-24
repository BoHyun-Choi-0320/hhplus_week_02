package com.bh.hhplus_week_02.datasource.repository;

import com.bh.hhplus_week_02.datasource.entity.LecturesHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLecturesHistoryRepository extends JpaRepository<LecturesHistory, Long> {
}
