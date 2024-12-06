package com.re_book.user.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@Builder
public class LoginRequestDTO {
    private String email;
    private String password;

}
