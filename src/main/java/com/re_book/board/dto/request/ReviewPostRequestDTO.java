package com.re_book.board.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewPostRequestDTO {

    private String memberUuid;
    private String nickName;

    @NotBlank(message = "리뷰 내용은 공백일 수 업습니다.")
    @Size(min = 1, max = 300, message = "리뷰 내용은 1자 이상, 300자 이하여야 합니다.")
    private String content;

    private Integer rating;

}
