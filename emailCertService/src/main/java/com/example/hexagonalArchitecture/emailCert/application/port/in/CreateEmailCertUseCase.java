package com.example.hexagonalArchitecture.emailCert.application.port.in;

import com.example.hexagonalArchitecture.emailCert.domain.EmailCert;

public interface CreateEmailCertUseCase {
    EmailCert createEmailCert(CreateEmailCertCommand command);
}
