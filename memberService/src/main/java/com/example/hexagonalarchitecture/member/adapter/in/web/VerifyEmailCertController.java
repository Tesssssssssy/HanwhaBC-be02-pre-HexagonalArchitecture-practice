package com.example.hexagonalarchitecture.member.adapter.in.web;

import com.example.hexagonalArchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.member.application.port.in.VerifyEmailCertCommand;
import com.example.hexagonalarchitecture.member.application.port.in.VerifyEmailCertUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class VerifyEmailCertController {
    private final VerifyEmailCertUseCase verifyEmailCertUseCase;

    // 인증 메일에 첨부되어 온 url을 클릭했을 때 실행되는 메소드
    @GetMapping("/member/confirm")
    Boolean verifyEmailCert(@RequestParam String email, @RequestParam String uuid) {
        VerifyEmailCertCommand command = VerifyEmailCertCommand.builder()
                .email(email)
                .uuid(uuid)
                .build();

        return verifyEmailCertUseCase.verifyEmailCert(command);
    }
}
