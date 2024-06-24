package com.bh.hhplus_week_02.presentation.controller;

import com.bh.hhplus_week_02.business.dto.LecturesDto;
import com.bh.hhplus_week_02.business.service.LecturesHistoryService;
import com.bh.hhplus_week_02.business.service.LecturesService;
import com.bh.hhplus_week_02.business.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures")
public class LecturesController {

    private final UsersService usersService;
    private final LecturesService lecturesService;
    private final LecturesHistoryService lecturesHistoryService;

    /*
        수강신청
        - 각 강의의 학생수 만큼 선착순으로 신청
        - 신청 가능한 수를 넘기면 신청 실패
        - 신청 내역 기록
     */
    @PostMapping("/apply")
    public void lectureApply(@RequestParam Long lectureId, @RequestParam Long userId){
        // 강의 신청
        boolean applySuccessOrFail = lecturesHistoryService.applyLecture(lectureId, userId);

    }

    /*
        특강 목록 반환
     */
    @GetMapping("/")
    public List<LecturesDto> lectureSelect(){
        List<LecturesDto> lecturesDtos = lecturesService.findAllByLectures();
        return lecturesDtos;
    }

    /*
        특강 신청 완료 여부 조회
        - userId 입력
        - 성공 여부 True/False 반환
     */
    @GetMapping("/application/{userId}")
    public boolean lecturesApplyCheck(@PathVariable Long userId){

        // lecturesHistory에서 사용자의 신청 완료 여부 반환
        boolean response = lecturesHistoryService.findByLecturesHistory(userId);
        return response;
    }
}
