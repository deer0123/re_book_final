package com.re_book.user.dto;

import com.re_book.user.entity.Role;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResDto {

    private String id;
    private String name;
    private String email;
    private Role role;

}