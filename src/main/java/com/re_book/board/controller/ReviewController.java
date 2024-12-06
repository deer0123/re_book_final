package com.re_book.board.controller;


import com.re_book.board.dto.request.ReviewPostRequestDTO;
import com.re_book.board.dto.request.ReviewUpdateRequestDTO;
import com.re_book.board.service.ReviewService;
import com.re_book.common.auth.TokenUserInfo;
import com.re_book.common.dto.CommonErrorDto;
import com.re_book.common.auth.JwtTokenProvider;
import com.re_book.common.dto.CommonResDto;
import com.re_book.entity.Review;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("board/detail")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;


    // 리뷰 작성
    @PostMapping("/{bookId}/create")
    public ResponseEntity<?> createReview(
            @PathVariable String bookId,
            @RequestBody @Valid ReviewPostRequestDTO dto,
            @AuthenticationPrincipal TokenUserInfo userInfo) {

        log.info("bookId: {}", bookId);
        log.info("dto: {}", dto);

        if (userInfo == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "로그인이 필요합니다."); // 로그인되지 않았다는 메시지

            CommonResDto errorResDto = new CommonResDto(HttpStatus.UNAUTHORIZED, "로그인 필요", errorResponse);
            return new ResponseEntity<>(errorResDto, HttpStatus.UNAUTHORIZED); // 401 Unauthorized 응답
        }

        Map<String, Object> response = new HashMap<>();

        try {
            String memberUuid = userInfo.getId();
            Review savedReview = reviewService.register(bookId, dto, memberUuid);
            response.put("success", true);
            response.put("message", "리뷰가 성공적으로 작성되었습니다.");
            response.put("reviewId", savedReview.getId());
            response.put("memberName", savedReview.getMember().getName());
            response.put("content", savedReview.getContent());
            response.put("rating", savedReview.getRating());
            response.put("memberId",savedReview.getMember().getId());
            response.put("createDate", savedReview.getCreatedDate());

            CommonResDto resDto
                    = new CommonResDto(HttpStatus.OK, "리뷰 작성 완료", response);
            return new ResponseEntity<>(resDto, HttpStatus.OK);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "리뷰 작성 중 오류가 발생했습니다.");
            log.error("Error creating review", e);

            CommonErrorDto errorDto
                    = new CommonErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);

        }
    }

    // 리뷰 수정
    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(
            @PathVariable String reviewId,
            @Valid @RequestBody ReviewUpdateRequestDTO dto,
            @AuthenticationPrincipal TokenUserInfo userInfo) {
        log.info("reviewId: {}", reviewId);


        if (userInfo == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "로그인이 필요합니다."); // 로그인되지 않았다는 메시지

            CommonResDto errorResDto = new CommonResDto(HttpStatus.UNAUTHORIZED, "로그인 필요", errorResponse);
            return new ResponseEntity<>(errorResDto, HttpStatus.UNAUTHORIZED); // 401 Unauthorized 응답
        }

        Map<String, Object> response = new HashMap<>();

        try {
            String memberUuid = userInfo.getId();
            reviewService.updateReview(reviewId, dto.getContent(), memberUuid);
            Review updatedReview = reviewService.findById(reviewId);

            response.put("success", true);
            response.put("message", "리뷰가 성공적으로 수정되었습니다.");
            response.put("reviewId", updatedReview.getId());
            response.put("nickname", updatedReview.getMember().getName());
            response.put("content", updatedReview.getContent());
            response.put("rating", updatedReview.getRating());

            CommonResDto resDto
                    = new CommonResDto(HttpStatus.OK, "리뷰 수정 완료", response);
            return new ResponseEntity<>(resDto, HttpStatus.OK);
        } catch (SecurityException e) {
            response.put("success", false);
            response.put("message", e.getMessage());

            CommonErrorDto errorDto
                    = new CommonErrorDto(HttpStatus.FORBIDDEN, e.getMessage());
            return new ResponseEntity<>(errorDto, HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "리뷰 수정 중 오류가 발생했습니다.");
            log.error("Error updating review", e);

            CommonErrorDto errorDto
                    = new CommonErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //리뷰 삭제
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(
            @PathVariable String reviewId,
            @AuthenticationPrincipal TokenUserInfo userInfo) {

        if (userInfo == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "로그인이 필요합니다."); // 로그인되지 않았다는 메시지

            CommonResDto errorResDto = new CommonResDto(HttpStatus.UNAUTHORIZED, "로그인 필요", errorResponse);
            return new ResponseEntity<>(errorResDto, HttpStatus.UNAUTHORIZED); // 401 Unauthorized 응답
        }
        Map<String, Object> response = new HashMap<>();



        try {
            String memberUuid = userInfo.getId();
            reviewService.deleteReview(reviewId, memberUuid);
            response.put("success", true);
            response.put("message", "리뷰가 성공적으로 삭제되었습니다.");

            CommonResDto resDto
                    = new CommonResDto(HttpStatus.OK, "리뷰 삭제 완료", response);
            return new ResponseEntity<>(resDto, HttpStatus.OK);
        } catch (SecurityException e) {
            response.put("success", false);
            response.put("message", e.getMessage());

            CommonErrorDto errorDto
                    = new CommonErrorDto(HttpStatus.FORBIDDEN, e.getMessage());
            return new ResponseEntity<>(errorDto, HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "리뷰 삭제 중 오류가 발생했습니다.");
            log.error("Error deleting review", e);

            CommonErrorDto errorDto
                    = new CommonErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}



