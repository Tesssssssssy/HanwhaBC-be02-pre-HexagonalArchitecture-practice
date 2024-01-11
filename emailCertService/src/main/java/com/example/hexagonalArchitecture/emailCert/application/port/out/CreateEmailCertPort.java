package com.example.hexagonalArchitecture.emailCert.application.port.out;

import com.example.hexagonalArchitecture.emailCert.adapter.out.persistence.EmailCertJpaEntity;
import com.example.hexagonalArchitecture.emailCert.domain.EmailCert;

public interface CreateEmailCertPort {
    EmailCertJpaEntity createEmailCert(EmailCert emailCert);
}
