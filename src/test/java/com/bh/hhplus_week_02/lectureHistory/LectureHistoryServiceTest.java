package com.bh.hhplus_week_02.lectureHistory;

import com.bh.hhplus_week_02.business.dto.LectureDto;
import com.bh.hhplus_week_02.business.repository.LectureHistoryRepository;
import com.bh.hhplus_week_02.business.repository.LectureRepository;
import com.bh.hhplus_week_02.business.service.LectureHistoryService;
import com.bh.hhplus_week_02.business.service.LectureService;
import com.bh.hhplus_week_02.datasource.entity.Lecture;
import com.bh.hhplus_week_02.datasource.repository.LectureHistoryJpaRepository;
import com.bh.hhplus_week_02.datasource.repository.LectureJpaRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class LectureHistoryServiceTest {

    @Autowired
    private LectureHistoryService lectureHistoryService;

    @Autowired
    private LectureJpaRepository lectureJpaRepository;

    @Autowired
    private LectureHistoryJpaRepository lectureHistoryJpaRepository;


    private Long lectureId;

    @BeforeEach
    public void setUp() {
        // 데이터베이스 초기화
        Lecture lecture = new Lecture("강의1", 20, LocalDateTime.of(2024, 7, 10, 15, 0,0));
        lectureJpaRepository.save(lecture);
        lectureId = lecture.getLectureId();
        System.out.println("lectureId : "+lectureId);
    }


    @Test
    @DirtiesContext
    @Transactional
    public void testConcurrencySaveLectureHistory() throws InterruptedException {
        int enrollmentCapacity = lectureJpaRepository.findByLectureId(lectureId).getStudentNum();

        // 병렬로 여러 사용자가 수강신청을 시도
        ExecutorService executorService = Executors.newFixedThreadPool(10); // 예시로 10개의 스레드 풀 생성

        try {
            for (int i = 0; i < enrollmentCapacity + 5; i++) {
                int userId = i + 1;
                executorService.submit(() -> {
                    try {
                        lectureHistoryService.saveLectureHistory(lectureId, (long) userId);
                    } catch (RuntimeException e) {
                        // 예외 발생 시 출력
                        System.out.println("예외 발생: " + e.getMessage());
                    }
                });
            }

            // 모든 작업이 완료될 때까지 대기
            executorService.shutdown();
            executorService.awaitTermination(30, TimeUnit.SECONDS); // 대기 시간을 적절히 조절

            // 추가적인 검증 로직을 여기에 추가할 수 있음
        } finally {
            if (!executorService.isTerminated()) {
                executorService.shutdownNow();
            }
        }
    }

}
