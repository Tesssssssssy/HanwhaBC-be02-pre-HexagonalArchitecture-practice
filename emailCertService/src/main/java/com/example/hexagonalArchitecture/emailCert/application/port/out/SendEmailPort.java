package com.example.hexagonalArchitecture.emailCert.application.port.out;

import com.example.hexagonalArchitecture.emailCert.domain.EmailCert;

public interface SendEmailPort {
    void sendEmail(EmailCert emailCert);
}
