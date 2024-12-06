package com.re_book.repository;


import com.re_book.entity.Book;
import com.re_book.entity.BookLike;
import com.re_book.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLikeRepository extends JpaRepository<BookLike, String> {
    boolean existsByBookIdAndMemberId(String bookId, String memberUuid);
    void deleteByBookIdAndMemberId(String bookId, String memberUuid);

    BookLike findByBookAndMember(Book book, Member member);
}
