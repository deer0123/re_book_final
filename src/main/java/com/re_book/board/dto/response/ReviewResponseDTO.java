package com.re_book.board.dto.response;

import com.re_book.entity.Review;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@Setter

public class ReviewResponseDTO {
    private final String reviewId;
    private int rating;
    private final String content;
    private final String memberName;
    private String memberUuid;
    private LocalDateTime createdDate;

    private int reviewCount;




    public ReviewResponseDTO(Review review) {
        this.reviewId = review.getId(); // id를 reviewId로 변환
        this.rating = review.getRating();
        this.content = review.getContent();
        this.memberName = review.getMember().getName();
        this.memberUuid = review.getMember().getId();
        this.reviewCount = review.getBook().getReviewCount();
        this.createdDate = review.getCreatedDate();
    }


}
