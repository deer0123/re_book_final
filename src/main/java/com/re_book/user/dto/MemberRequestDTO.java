package com.re_book.user.dto;


import com.re_book.entity.Member;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter @Setter @ToString
@Builder
@AllArgsConstructor
public class MemberRequestDTO {
    private String email;
    private String nickname;
    private String password;

    public Member toEntity(PasswordEncoder encoder) {
        return Member.builder()
                .email(email)
                .name(nickname)
                .password(encoder.encode(password))
                .build();
    }
}