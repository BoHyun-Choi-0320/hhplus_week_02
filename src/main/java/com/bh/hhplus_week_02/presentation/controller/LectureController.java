package com.bh.hhplus_week_02.presentation.controller;

import com.bh.hhplus_week_02.business.dto.LectureDto;
import com.bh.hhplus_week_02.business.service.LectureHistoryService;
import com.bh.hhplus_week_02.business.service.LectureService;
import com.bh.hhplus_week_02.business.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures")
public class LectureController {

    private final UserService userService;
    private final LectureService lectureService;
    private final LectureHistoryService lectureHistoryService;

    /*
        수강신청
        - 각 강의의 학생수 만큼 선착순으로 신청
        - 신청 가능한 수를 넘기면 신청 실패
        - 신청 내역 기록
     */
    @PostMapping("/apply")
    public void registrationLecture(@RequestParam Long lectureId, @RequestParam Long userId){
        lectureHistoryService.saveLectureHistory(lectureId, userId);
    }

    /*
        특강 목록 반환
        - 날짜별로 특강이 존재 -> 범용적 서비스
        - 신청 정원이 특강마다 다르게 처리 가능하도록 구현
     */
    @GetMapping("/")
    public List<LectureDto> getLectures(){
        return lectureService.findAllLectures();
    }

    /*
        특강 신청 완료 여부 조회
        - userId 입력
        - 성공 여부 True/False 반환
     */
    @GetMapping("/application/{userId}")
    public boolean verifyLectureRegistration(@PathVariable Long userId, @RequestParam Long lectureId){
        // lecturesHistoryService에서 사용자의 신청 완료 여부 반환
        return lectureHistoryService.verifyLectureRegistration(userId, lectureId);

    }
}
