package com.bh.hhplus_week_02.business.service;

import com.bh.hhplus_week_02.business.dto.LectureHistoryDto;
import com.bh.hhplus_week_02.business.repository.LectureHistoryRepository;
import com.bh.hhplus_week_02.business.repository.LectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LectureHistoryService {

    private LectureHistoryRepository lectureHistoryRepository;
    private final LectureRepository lectureRepository;

    public LectureHistoryService(LectureHistoryRepository lectureHistoryRepository, LectureRepository lectureRepository) {
        this.lectureHistoryRepository = lectureHistoryRepository;
        this.lectureRepository = lectureRepository;
    }

    @Transactional
    public boolean verifyLectureRegistration(Long userId, Long lectureId){
        boolean validation = lectureHistoryRepository.existsByUserIdAndLectureId(userId, lectureId);
        return validation;
    }

    @Transactional
    public void saveLectureHistory(Long lectureId, Long userId){
        // 최대정원수 가져오기
        int enrollmentCapacity = lectureRepository.findByLectureId(lectureId).studentNum();

        // 신청한 학생 수
        int numOfStudent = lectureHistoryRepository.countLectureHistoryByLectureId(lectureId);
        System.out.println("최대정원수 : "+enrollmentCapacity+", 신청학생 수 : "+numOfStudent);

        // 수강생 수가 최대정원수를 넘기면 예외처리
        if(enrollmentCapacity < numOfStudent+1){
            throw new RuntimeException("수강 신청이 마감되었습니다.");
        }

        boolean validate = lectureHistoryRepository.existsByUserIdAndLectureId(userId, lectureId);

        if(validate){
            throw new RuntimeException("이미 신청한 강의 입니다.");
        }

        // 수강신청 정보 생성
        LectureHistoryDto lectureHistoryDto = new LectureHistoryDto(userId, lectureId);

        // 수강신청 정보 저장
        lectureHistoryRepository.save(lectureHistoryDto);
    }
}
