package com.re_book.entity;

import com.re_book.user.dto.UserResDto;
import com.re_book.user.entity.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tbl_members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="member_uuid")
    private String id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Builder.Default // build시 초기화된 값으로 세팅하기 위한 아노테이션
    private Role role = Role.USER;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews; // 작성한 리뷰 목록

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "liked_books",
            joinColumns = @JoinColumn(name = "member_uuid"),
            inverseJoinColumns = @JoinColumn(name = "book_uuid")
    )
    private List<Book> likedBooks; // 좋아요한 책 목록

    public UserResDto fromEntity() {
        return UserResDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .role(role)
                .build();
    }
}
