package com.bh.hhplus_week_02.business.service;

import com.bh.hhplus_week_02.business.repository.LecturesHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class LecturesHistoryService {

    private LecturesHistoryRepository lecturesHistoryRepository;

    public LecturesHistoryService(LecturesHistoryRepository lecturesHistoryRepository) {
        this.lecturesHistoryRepository = lecturesHistoryRepository;
    }
}
