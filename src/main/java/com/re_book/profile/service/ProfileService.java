package com.re_book.profile.service;

import com.re_book.entity.Member;
import com.re_book.profile.dto.LikedBooksResponseDTO;
import com.re_book.profile.dto.MyReviewResponseDTO;
import com.re_book.profile.dto.ProfileMemberResponseDTO;
import com.re_book.user.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProfileService {

    private final MemberService memberService;


    @Transactional
    public Page<LikedBooksResponseDTO> getLikedBooksForMember(String id, Pageable page) {
        Member member = memberService.findById(id).orElseThrow();
        if (member != null) {
            List<LikedBooksResponseDTO> likedBooksList = member.getLikedBooks().stream()
                    .map(book -> LikedBooksResponseDTO.builder()
                            .id(book.getId())
                            .name(book.getName())
                            .writer(book.getWriter())
                            .pub(book.getPub())
                            .coverImage(book.getCoverImage())
                            .rating(book.getRating())
                            .reviewCount(book.getReviewCount())
                            .likeCount(book.getLikeCount())
                            .build())
                    .collect(Collectors.toList());

            // 역순으로 정렬
            Collections.reverse(likedBooksList);

            // 실제 페이지에 맞게 서브리스트로 제한
            int start = Math.toIntExact(page.getOffset());
            int end = Math.min(start + page.getPageSize(), likedBooksList.size());
            List<LikedBooksResponseDTO> pagedList = likedBooksList.subList(start, end);

            return new PageImpl<>(pagedList, page, likedBooksList.size());
        }
        return new PageImpl<>(Collections.emptyList(), page, 0);
    }




    public Page<MyReviewResponseDTO> getMyReviewsForMember(String id, Pageable page) {
        Member member = memberService.findById(id).orElseThrow();
        log.info("member: {}", member);

        if (member != null) {
            List<MyReviewResponseDTO> list = new java.util.ArrayList<>(member.getReviews().stream()
                    .map(MyReviewResponseDTO::fromReview)
                    .toList());

            Collections.reverse(list);

            // 실제 페이지에 맞게 서브리스트로 제한
            int start = Math.toIntExact(page.getOffset());
            int end = Math.min(start + page.getPageSize(), list.size());
            List<MyReviewResponseDTO> pagedList = list.subList(start, end);

            return new PageImpl<>(pagedList, page, list.size());
        }
        return new PageImpl<>(Collections.emptyList(), page, 0);
    }

    public ProfileMemberResponseDTO getMyProfile(String id) {
        Member member = memberService.findById(id).orElseThrow();
        if (member != null) {
            return ProfileMemberResponseDTO.builder()
                    .nickname(member.getName())
                    .email(member.getEmail())
                    .createdAt(member.getCreatedAt())
                    .build();
        }
        return null;
    }

    public void changeNickname(String id, String newNickname) {
        Member member = memberService.findById(id).orElseThrow();
        if (member != null) {
            member.setName(newNickname);
            memberService.update(member); // 회원 정보를 업데이트하는 메서드 호출
        }
    }



}
