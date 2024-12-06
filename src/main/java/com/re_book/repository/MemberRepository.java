package com.re_book.repository;



import com.re_book.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);

}