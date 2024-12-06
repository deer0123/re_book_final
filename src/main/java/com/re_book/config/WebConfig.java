package com.re_book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://re-book-front1326.s3-website.ap-northeast-2.amazonaws.com") // 리액트 클라이언트 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 필요한 HTTP 메서드만 설정
                .allowedHeaders("*") // 모든 헤더 허용
                .allowCredentials(true); // 인증 정보를 포함한 요청 허용
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

