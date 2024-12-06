package com.re_book.board.controller;


import com.re_book.board.dto.response.HomeRecommendedResponseDTO;
import com.re_book.board.service.HomeService;
import com.re_book.common.dto.CommonResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/")
    public ResponseEntity<?> home() {
        List<HomeRecommendedResponseDTO> recommendedByRating = homeService.recommendedListByRating();
        List<HomeRecommendedResponseDTO> recommendedByReviewCount = homeService.recommendedListByReviewCount();
        List<HomeRecommendedResponseDTO> recommendedByLikeCount = homeService.recommendedListByLikeCount();

        Map<String, List<HomeRecommendedResponseDTO>> response = new HashMap<>();
        response.put("recommendedByRating", recommendedByRating);
        response.put("recommendedByReviewCount", recommendedByReviewCount);
        response.put("recommendedByLikeCount", recommendedByLikeCount);

        CommonResDto resDto
                = new CommonResDto(HttpStatus.OK, "홈화면 출력 완료", response);

        return new ResponseEntity<>(resDto, HttpStatus.OK); // 성공 시 OK 상태 코드와 함께 반환
    }

}
