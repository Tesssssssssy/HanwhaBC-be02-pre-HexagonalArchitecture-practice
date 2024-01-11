package com.example.hexagonalArchitecture.emailCert.adapter.out.email;

import com.example.hexagonalArchitecture.common.ExternalSystemAdapter;
import com.example.hexagonalArchitecture.emailCert.application.port.out.SendEmailPort;
import com.example.hexagonalArchitecture.emailCert.domain.EmailCert;
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
        message.setFrom("dlaxodn9999@gmail.com");
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
