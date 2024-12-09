package com.re_book.board.service;


import com.re_book.board.dto.request.ReviewPostRequestDTO;
import com.re_book.board.dto.response.ReviewResponseDTO;
import com.re_book.entity.Book;
import com.re_book.entity.Member;
import com.re_book.entity.Review;
import com.re_book.repository.BookRepository;
import com.re_book.repository.MemberRepository;
import com.re_book.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public Page<ReviewResponseDTO> getReviewList(String bookId, Pageable pageable) {
        Page<Review> reviews = reviewRepository.findByBookIdOrderByCreatedDateDesc(bookId, pageable);

        // Review를 ReviewResponseDTO로 변환
        return reviews.map(review -> ReviewResponseDTO.builder()
                .reviewId(review.getId())
                .content(review.getContent())
                .rating(review.getRating())
                .memberUuid(review.getMember().getId())
                .memberName(review.getMember().getName())
                .createdDate(review.getCreatedDate())
                .build());
    }

    public ReviewResponseDTO register(String bookId, ReviewPostRequestDTO dto, String userInfo) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("책을 찾을 수 없습니다."));

        Member member = memberRepository.findById(userInfo)
                .orElseThrow(() -> new EntityNotFoundException("회원 정보를 찾을 수 없습니다."));

        Review review = Review.builder()
                .member(member)
                .book(book)
                .content(dto.getContent())
                .rating(dto.getRating())
                .build();

        reviewRepository.save(review);

        book.setReviewCount(book.getReviewCount() + 1);
        book.setRating(book.getRating() + dto.getRating());
        bookRepository.save(book);

        return new ReviewResponseDTO(review);
    }

    public void updateReview(String reviewId, String newContent, String userId, int newRating) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("리뷰를 찾을 수 없습니다."));

        // 본인의 리뷰인지 확인
        if (!review.getMember().getId().equals(userId)) {
            throw new SecurityException("본인의 리뷰만 수정할 수 있습니다.");
        }

        review.setContent(newContent);
        review.setRating(newRating);
        reviewRepository.save(review);
    }

    public void deleteReview(String reviewId, String userId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("리뷰를 찾을 수 없습니다."));

        // 본인의 리뷰인지 확인
        if (!review.getMember().getId().equals(userId)) {
            throw new SecurityException("본인의 리뷰만 삭제할 수 있습니다.");
        }

        Book book = review.getBook();
        reviewRepository.deleteById(reviewId);

        book.setReviewCount(book.getReviewCount() - 1);
        book.setRating(book.getRating() - review.getRating());
        bookRepository.save(book);
    }

    public Review findById(String reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("리뷰를 찾을 수 없습니다."));
    }
}
