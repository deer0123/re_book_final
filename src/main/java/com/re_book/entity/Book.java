package com.re_book.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString(exclude = "reviews") // 순환 참조 방지를 위해 reviews 제외
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder

@Entity
@Table(name = "tbl_books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // UUID 생성 전략
    @Column(name="book_uuid")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String pub;

    @Column(nullable = false)
    private int year;

    @Builder.Default
    @Column(nullable = false)
    private double rating = 0.0;

    @Builder.Default
    @Column(nullable = false)
    private int reviewCount = 0;

    @Builder.Default
    @Column(nullable = false)
    private int likeCount = 0;

    private String coverImage;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // 리뷰와의 관계 추가
    private List<Review> reviews; // 해당 책에 대한 리뷰 목록
}
