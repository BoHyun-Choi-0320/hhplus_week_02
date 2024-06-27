package com.bh.hhplus_week_02.business.service;

import com.bh.hhplus_week_02.business.dto.LectureDto;
import com.bh.hhplus_week_02.business.dto.LectureHistoryDto;
import com.bh.hhplus_week_02.business.repository.LectureHistoryRepository;
import com.bh.hhplus_week_02.business.repository.LectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Transactional
    public List<LectureDto> findAllLectures(){
        return lectureRepository.findAll();
    }

}
