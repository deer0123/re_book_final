package com.re_book.user.dto;


import com.re_book.entity.Book;
import com.re_book.entity.Review;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserResponseDTO {
    private String uuid;
    private String email;
    private String nickname;
    private List<Review> reviews;
    private List<Book> likedBooks;
}
