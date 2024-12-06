package com.re_book.board.service;


import com.re_book.board.dto.response.HomeRecommendedResponseDTO;
import com.re_book.entity.Book;
import com.re_book.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HomeService {
    private final BookRepository bookRepository;


    // 평점 순으로 3개의 책 추천
    public List<HomeRecommendedResponseDTO> recommendedListByRating() {
        List<Book> books = bookRepository.findTop3ByOrderByRatingDividedByReviewCountDesc(PageRequest.of(0, 3));
        // 평점 순 상위 3개
        return books.stream()
                .map(book -> new HomeRecommendedResponseDTO(
                       book.getId(),
                        book.getName(),
                        book.getWriter(),
                        book.getPub(),
                        book.getCoverImage(),
                        book.getRating(),
                        book.getReviewCount(),
                        book.getLikeCount()
                )).toList();
    }

    // 리뷰 수 순으로 3개의 책 추천
    public List<HomeRecommendedResponseDTO> recommendedListByReviewCount() {
        List<Book> books = bookRepository.findTop3ByOrderByReviewCountDesc();  // 리뷰 수 상위 3개
        return books.stream()
                .map(book -> new HomeRecommendedResponseDTO(
                        book.getId(),
                        book.getName(),
                        book.getWriter(),
                        book.getPub(),
                        book.getCoverImage(),
                        book.getRating(),
                        book.getReviewCount(),
                        book.getLikeCount()
                )).toList();
    }

    // 좋아요 수 순으로 3개의 책 추천
    public List<HomeRecommendedResponseDTO> recommendedListByLikeCount() {
        List<Book> books = bookRepository.findTop3ByOrderByLikeCountDesc();  // 좋아요 수 상위 3개
        return books.stream()
                .map(book -> new HomeRecommendedResponseDTO(
                        book.getId(),
                        book.getName(),
                        book.getWriter(),
                        book.getPub(),
                        book.getCoverImage(),
                        book.getRating(),
                        book.getReviewCount(),
                        book.getLikeCount()
                )).toList();
    }
}
