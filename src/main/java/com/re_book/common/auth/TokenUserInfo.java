package com.re_book.common.auth;


import com.re_book.user.entity.Role;
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenUserInfo {

    private String id;
    private Role role;
    private String name;

}
