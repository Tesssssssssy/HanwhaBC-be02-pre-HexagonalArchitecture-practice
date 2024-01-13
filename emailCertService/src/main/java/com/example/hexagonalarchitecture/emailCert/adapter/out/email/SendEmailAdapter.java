package com.example.hexagonalarchitecture.emailCert.adapter.out.email;

import com.example.hexagonalarchitecture.common.ExternalSystemAdapter;
import com.example.hexagonalarchitecture.emailCert.application.port.out.SendEmailPort;
import com.example.hexagonalarchitecture.emailCert.domain.EmailCert;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class SendEmailAdapter implements SendEmailPort {
    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmail(EmailCert emailCert) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailCert.getEmail());
        message.setSubject("[LTW] 이메일 인증");
        message.setSentDate(new Date(System.currentTimeMillis()));
        message.setText("http://localhost:9999/member/confirm?email="
                + emailCert.getEmail()
                + "&uuid=" + emailCert.getUuid()
        );
        javaMailSender.send(message);
    }
}
