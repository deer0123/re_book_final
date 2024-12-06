package com.re_book.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "book_likes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter @Getter
public class BookLike {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "book_uuid")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_uuid")
    private Member member;

}