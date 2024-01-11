package com.example.hexagonalArchitecture.emailCert.adapter.in.web;

import com.example.hexagonalArchitecture.common.WebAdapter;
import com.example.hexagonalArchitecture.emailCert.application.port.in.VerifyEmailCertCommand;
import com.example.hexagonalArchitecture.emailCert.application.port.in.VerifyEmailCertUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class VerifyEmailCertController {
    private final VerifyEmailCertUseCase verifyEmailCertUseCase;

    // memberService에서 회원가입 후 호출받는 메소드
    @GetMapping("/emailcert/verify")
    Boolean verifyEmailCert(@RequestParam String email, @RequestParam String uuid) {
        VerifyEmailCertCommand command = VerifyEmailCertCommand.builder()
                .email(email)
                .uuid(uuid)
                .build();

        return verifyEmailCertUseCase.verifyEmailCert(command);
    }
}
