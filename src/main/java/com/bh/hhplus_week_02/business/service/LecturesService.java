package com.bh.hhplus_week_02.business.service;

import com.bh.hhplus_week_02.business.repository.LecturesRepository;
import org.springframework.stereotype.Service;

@Service
public class LecturesService {
    private final LecturesRepository lecturesRepository;

    public LecturesService(LecturesRepository lecturesRepository) {
        this.lecturesRepository = lecturesRepository;
    }
}
