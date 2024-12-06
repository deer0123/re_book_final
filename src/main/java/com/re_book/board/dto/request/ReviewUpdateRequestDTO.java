package com.re_book.board.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewUpdateRequestDTO {
    private String content;
}
