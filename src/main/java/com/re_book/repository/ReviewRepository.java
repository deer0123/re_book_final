package com.re_book.repository;

import com.re_book.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, String> {
    
    Page<Review> findByBookIdOrderByCreatedDateDesc(String bookId, Pageable pageable);
}
