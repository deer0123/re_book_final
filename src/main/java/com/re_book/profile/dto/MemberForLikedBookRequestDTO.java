package com.re_book.profile.dto;

import com.re_book.entity.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@Builder
public class MemberForLikedBookRequestDTO {
    private List<Book> likedBooks;
}
