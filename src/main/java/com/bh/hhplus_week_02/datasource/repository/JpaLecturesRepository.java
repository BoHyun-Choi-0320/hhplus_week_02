package com.bh.hhplus_week_02.datasource.repository;

import com.bh.hhplus_week_02.business.dto.LecturesDto;
import com.bh.hhplus_week_02.datasource.entity.Lectures;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaLecturesRepository extends JpaRepository<Lectures, Long> {
    List<Lectures> findAll();
}
