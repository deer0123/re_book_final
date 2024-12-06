package com.re_book.board.dto.response;


import com.re_book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@Builder
public class BookDetailResponseDTO {
    private String id;
    private String name;
    private String writer;
    private String pub;
    private int year;
    private final String coverImage;
    private double rating;
    private int reviewCount;
    private int likeCount;
    private boolean isLiked;

    // 생성자
    public BookDetailResponseDTO(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.writer = book.getWriter();
        this.pub = book.getPub();
        this.year = book.getYear();
        this.coverImage = book.getCoverImage();
        this.rating = book.getRating();
        this.reviewCount = book.getReviewCount();
        this.likeCount = book.getLikeCount();
        this.isLiked = false;
    }
}
