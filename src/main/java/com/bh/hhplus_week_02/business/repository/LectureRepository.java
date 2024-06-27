package com.bh.hhplus_week_02.business.repository;


import com.bh.hhplus_week_02.business.dto.LectureDto;

import java.util.List;

public interface LectureRepository {
    List<LectureDto> findAll();
    LectureDto findByLectureId(Long lectureId);

}
