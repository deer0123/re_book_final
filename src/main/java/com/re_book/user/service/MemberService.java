package com.re_book.user.service;


import com.re_book.entity.Member;
import com.re_book.repository.MemberRepository;
import com.re_book.user.dto.LoginRequestDTO;
import com.re_book.user.dto.MemberRequestDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    private final JavaMailSender mailSender;
    public void save(MemberRequestDTO dto) {

        Member member = dto.toEntity(encoder);
        memberRepository.save(member);
    }

    public void save(Member member) {
        memberRepository.save(member);
    }

    public Member login(LoginRequestDTO dto) {
        // 이메일로 멤버 조회
        Member member = memberRepository.findByEmail(dto.getEmail()).orElseThrow(() ->
                new EntityNotFoundException("User not found")
        );
        // 비밀번호 확인하기 (암호화 되어있으니 encoder에게 부탁)
        if (!encoder.matches(dto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return member;
        }


    public String sendAuthCode(String email) throws MessagingException {
        // 난수 생성
        String authCode = generateAuthCode();

        String setFrom = "book4wtest@gmail.com"; // 발신용 이메일 주소(properties랑 똑같아야 함!)
        String toMail = email; // 수신받을 이메일 (가입하고자 하는 사람의 이메일)
        String title = "Book4W 회원가입 인증 이메일입니다."; // 실제 이메일 제목
        String content = "홈페이지 가입을 신청해 주셔서 감사합니다." +
                "<br><br>" +
                "인증 번호는 <strong>" + authCode + "</strong>입니다. <br>" +
                "해당 인증 번호를 인증번호 확인란에 기입해 주세요."; // 이메일에 삽입할 내용 (더 꾸며보세요)

        sendMail(setFrom, toMail, title, content);

        return authCode;
    }

    private String generateAuthCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);  // 6자리 난수 생성
        return String.valueOf(code);
    }

    // 여기서 실제 이메일이 전송
    private void sendMail(String setFrom, String toMail, String title, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        /*
            기타 설정들을 담당할 MimeMessageHelper 객체를 생성
            생성자의 매개값으로 MimeMessage 객체, bool, 문자 인코딩 설정
            true 매개값을 전달하면 MultiPart 형식의 메세지 전달이 가능 (첨부 파일)
        */
        MimeMessageHelper helper
                = new MimeMessageHelper(message, false, "utf-8");
        helper.setFrom(setFrom);
        helper.setTo(toMail);
        helper.setSubject(title);

        // 내용 채우기 (true를 전송하면 html이 포함되어 있다. 값을 안주면 단순 텍스트로만 전달됨.)
        helper.setText(content, true);

        // 메일 전송
        mailSender.send(message);
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("User not found")
        );
    }

    public Optional<Member> existInEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public void update(Member member) {
        memberRepository.save(member);
    }

    public Optional<Member> findById(String memberUuid) {
        return memberRepository.findById(memberUuid);
    }

    public Member findByUuid(String memberUuid) {
        return memberRepository.findById(memberUuid).orElse(null);
    }

}