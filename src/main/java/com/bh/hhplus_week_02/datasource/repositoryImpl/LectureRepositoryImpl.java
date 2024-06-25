package com.bh.hhplus_week_02.datasource.repositoryImpl;

import com.bh.hhplus_week_02.business.dto.LectureDto;
import com.bh.hhplus_week_02.business.repository.LectureRepository;
import com.bh.hhplus_week_02.datasource.entity.Lecture;
import com.bh.hhplus_week_02.datasource.repository.LectureJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LectureRepositoryImpl implements LectureRepository {

    private final LectureJpaRepository lecturesJpaRepository;

    public LectureRepositoryImpl(LectureJpaRepository lecturesJpaRepository) {
        this.lecturesJpaRepository = lecturesJpaRepository;
    }


    @Override
    public List<LectureDto> findAll() {
        List<Lecture> lectureList = lecturesJpaRepository.findAll();
        List<LectureDto> lectureDtoList = lectureList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return lectureDtoList;
    }

    @Override
    public LectureDto findByLectureId(Long lectureId) {
        Lecture lecture = lecturesJpaRepository.findByLectureId(lectureId);
        if(lecture == null){
            return null;
        }
        return convertToDto(lecture);
    }

    private LectureDto convertToDto(Lecture lecture){
        return new LectureDto(lecture.getLectureId(), lecture.getLectureName(), lecture.getStudentNum(), lecture.getLectureDate() );
    }
}
