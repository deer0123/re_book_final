package com.re_book.profile.controller;

import com.re_book.common.auth.JwtTokenProvider;
import com.re_book.common.auth.TokenUserInfo;
import com.re_book.common.dto.CommonErrorDto;
import com.re_book.common.dto.CommonResDto;
import com.re_book.profile.dto.LikedBooksResponseDTO;
import com.re_book.profile.dto.MyReviewResponseDTO;
import com.re_book.profile.dto.ProfileMemberResponseDTO;
import com.re_book.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
@Slf4j
public class ProfileController {

    private final ProfileService profileService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/info")
    public ResponseEntity<?> info(@RequestHeader("Authorization") String authorization,
                                  @AuthenticationPrincipal TokenUserInfo userInfo) {
        log.info("/profile/info: GET, authorization: {}", authorization);
        log.info("tokenUserInfo: {}", userInfo);
        Map<String, Object> response = new HashMap<>();

        if (userInfo != null) {
            log.info("회원 조회!");
            ProfileMemberResponseDTO member = profileService.getMyProfile(userInfo.getId());
            response.put("member", member);
        } else {
            return new ResponseEntity<>(new CommonErrorDto(HttpStatus.UNAUTHORIZED, "로그인하세요."), HttpStatus.UNAUTHORIZED);
        }
        CommonResDto resDto = new CommonResDto(HttpStatus.OK, "회원 정보 조회 완료", response);
        return new ResponseEntity<>(resDto, HttpStatus.OK);
    }

    @GetMapping("/liked-books")
    public ResponseEntity<?> likedBooks(@RequestHeader("Authorization") String authorization,
                                        @PageableDefault(page = 0, size = 5) Pageable page,
                                        @AuthenticationPrincipal TokenUserInfo userInfo) {
        if (userInfo == null) {
            return new ResponseEntity<>(new CommonErrorDto(HttpStatus.UNAUTHORIZED, "Invalid token or user not found"), HttpStatus.UNAUTHORIZED);
        }

        Page<LikedBooksResponseDTO> likedBooks = profileService.getLikedBooksForMember(userInfo.getId(), page);
        Map<String, Object> response = new HashMap<>();
        response.put("likedBooks", likedBooks);

        CommonResDto resDto = new CommonResDto(HttpStatus.OK, "좋아요한 책목록 조회 완료", response);
        return new ResponseEntity<>(resDto, HttpStatus.OK);
    }

    @GetMapping("/my-reviews")
    public ResponseEntity<?> myReviews(@RequestHeader("Authorization") String authorization,
                                       @PageableDefault(page = 0, size = 5) Pageable page,
                                       @AuthenticationPrincipal TokenUserInfo userInfo) {

        if (userInfo == null) {
            return new ResponseEntity<>(
                    new CommonErrorDto(HttpStatus.UNAUTHORIZED, "Invalid token or user not found"),
                    HttpStatus.UNAUTHORIZED
            );
        }

        Page<MyReviewResponseDTO> myReviews = profileService.getMyReviewsForMember(userInfo.getId(), page);
        Map<String, Object> response = new HashMap<>();
        response.put("myReviews", myReviews.getContent());
        response.put("pagination", myReviews);

        CommonResDto resDto = new CommonResDto(HttpStatus.OK, "내 리뷰 목록 조회 완료", response);
        return new ResponseEntity<>(resDto, HttpStatus.OK);
    }

    @PostMapping("/change-nickname")
    public ResponseEntity<?> changeNickname(@RequestHeader("Authorization") String authorization,
                                            @RequestBody Map<String, String> requestBody,
                                            @AuthenticationPrincipal TokenUserInfo userInfo) {

        if (userInfo == null) {
            return new ResponseEntity<>(
                    new CommonErrorDto(HttpStatus.UNAUTHORIZED, "Invalid token or user not found"),
                    HttpStatus.UNAUTHORIZED
            );
        }

        String newNickname = requestBody.get("newNickname");

        // 닉네임 변경 서비스 호출 및 예외 처리
        try {
            profileService.changeNickname(userInfo.getId(), newNickname);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new CommonErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류 발생"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        Map<String, Object> response = new HashMap<>();
        CommonResDto resDto = new CommonResDto(HttpStatus.OK, "닉네임 변경 성공", response);
        return new ResponseEntity<>(resDto, HttpStatus.OK);
    }


}

