package com.re_book.board.controller;

import com.re_book.board.dto.response.BookDetailResponseDTO;
import com.re_book.board.dto.response.DetailPageResponseDTO;
import com.re_book.board.dto.response.ReviewResponseDTO;
import com.re_book.board.service.BoardService;
import com.re_book.board.service.DetailService;
import com.re_book.board.service.ReviewService;
import com.re_book.common.auth.JwtTokenProvider;
import com.re_book.common.auth.TokenUserInfo;
import com.re_book.common.dto.CommonResDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;
    private final DetailService detailService;
    private final ReviewService reviewService;
    private final JwtTokenProvider jwtTokenProvider;

    // list입니다.
    @GetMapping("/list")
    public ResponseEntity<?> list(@PageableDefault(size = 9) Pageable page,
                       @RequestParam(required = false) String sort,
                       @RequestParam(required = false) String query) {
        Map<String, Object> response = new HashMap<>();


        // page 설정에 맞춰 북 목록을 Map에 저장하겠다.
        Page<BookDetailResponseDTO> bookPage;

        if (query != null && !query.trim().isEmpty()) {
            bookPage = getSortedBookPageForSearch(sort, page, query);
        } else {
            bookPage = getSortedBookPage(sort, page);
        }

        response.put("bList", bookPage.getContent());
        response.put("maker", bookPage);
        response.put("sort", sort);
        response.put("query", query);
        CommonResDto resDto
                = new CommonResDto(HttpStatus.OK, "책목록 조회 완료", response);
        return new ResponseEntity<>(resDto, HttpStatus.OK); // 성공 시 OK 상태 코드와 함께 반환
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detailPage(
            @PathVariable String id,
//            @PageableDefault(page = 0, size = 10) Pageable page,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @AuthenticationPrincipal TokenUserInfo userInfo) {

        log.info("Fetching detail for book id: {}", id);

        Map<String, Object> response = new HashMap<>();

        String memberId = (userInfo != null) ? userInfo.getId() : null;

        // 책 정보와 함께 좋아요 상태 및 좋아요 수 가져오기
        DetailPageResponseDTO bookDetail = detailService.getBookDetail(id, memberId);

        // 좋아요 상태 및 좋아요 수
        boolean isLiked = (memberId != null) && bookDetail.isLiked();
        int likeCount = bookDetail.getLikeCount();

        // Pageable 객체 생성
        Pageable pageable = PageRequest.of(page, size);
        // 리뷰 목록 가져오기
        Page<ReviewResponseDTO> reviewPage = reviewService.getReviewList(id, pageable);

        // 책 정보가 제대로 전달되는지 로그로 확인
        log.info("Book detail: {}", bookDetail);

        // 모델에 필요한 정보 추가
        response.put("book", bookDetail);
        response.put("isLiked", isLiked);
        response.put("likeCount", likeCount);
        response.put("reviewList", reviewPage.getContent());
        response.put("page", reviewPage);
        response.put("user", memberId); // 로그인 사용자 정보 (비로그인 시 null)
        CommonResDto resDto = new CommonResDto(HttpStatus.OK, "디테일페이지 조회 완료", response);
        return new ResponseEntity<>(resDto, HttpStatus.OK); // 성공 시 OK 상태 코드와 함께 반환
    }



    @PostMapping("/detail/{bookId}/toggle-like")
    @ResponseBody
    public ResponseEntity<?> toggleLike(
            @PathVariable String bookId,
            @RequestHeader("Authorization") String authorization,
            @AuthenticationPrincipal TokenUserInfo userInfo) {
        log.info("/toggle-like: POST, {}", bookId);

        if (userInfo == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "로그인이 필요합니다."); // 로그인되지 않았다는 메시지

            CommonResDto errorResDto = new CommonResDto(HttpStatus.UNAUTHORIZED, "로그인 필요", errorResponse);
            return new ResponseEntity<>(errorResDto, HttpStatus.UNAUTHORIZED); // 401 Unauthorized 응답
        }

        Map<String, Object> response = new HashMap<>();

        // 좋아요 토글 및 카운트 업데이트
        boolean isLiked = detailService.toggleLike(bookId, userInfo.getId());

        int likeCount = detailService.getBookDetail(bookId, userInfo.getId()).getLikeCount(); // 좋아요 수 업데이트
        response.put("success", true);
        response.put("isLiked", isLiked);
        response.put("likeCount", likeCount); // 좋아요 수를 응답에 포함

        CommonResDto resDto
                = new CommonResDto(HttpStatus.OK, "좋아요 토글 성공!", response);
        return new ResponseEntity<>(resDto, HttpStatus.OK); // 성공 시 OK 상태 코드와 함께 반환
    }

    // 종속성 메서드
    private Page<BookDetailResponseDTO> getSortedBookPage(String sort, Pageable pageable) {
        if (sort == null) {
            return boardService.getBookList(pageable);
        }

        return switch (sort) {
            case "likeCount" -> boardService.getOrderLikeDesc(pageable);
            case "reviewCount" -> boardService.getOrderReviewDesc(pageable);
            case "rating" -> boardService.getOrderRatingDesc(pageable);
            default -> boardService.getBookList(pageable);
        };
    }

    // 종속성 메서드
    private Page<BookDetailResponseDTO> getSortedBookPageForSearch(String sort, Pageable page,
                                                                   String query) {
        Page<BookDetailResponseDTO> books;

        if (sort == null) {
            books = boardService.searchByName(page, query);
        } else {
            books = switch (sort) {
                case "likeCount" -> boardService.searchByNameOrderByLikeDesc(page, query);
                case "reviewCount" -> boardService.searchBookByNameOrderByReviewDesc(page, query);
                case "rating" -> boardService.searchBookByNameOrderByRatingDesc(page, query);
                default -> boardService.searchByName(page, query);
            };
        }

        return books;
    }

}
