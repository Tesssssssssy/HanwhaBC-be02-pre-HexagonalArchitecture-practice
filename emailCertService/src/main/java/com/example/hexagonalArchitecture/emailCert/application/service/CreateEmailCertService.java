package com.example.hexagonalArchitecture.emailCert.application.service;

import com.example.hexagonalArchitecture.common.UseCase;
import com.example.hexagonalArchitecture.emailCert.adapter.out.persistence.EmailCertJpaEntity;
import com.example.hexagonalArchitecture.emailCert.application.port.in.CreateEmailCertCommand;
import com.example.hexagonalArchitecture.emailCert.application.port.in.CreateEmailCertUseCase;
import com.example.hexagonalArchitecture.emailCert.application.port.out.CreateEmailCertPort;
import com.example.hexagonalArchitecture.emailCert.application.port.out.SendEmailPort;
import com.example.hexagonalArchitecture.emailCert.domain.EmailCert;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class CreateEmailCertService implements CreateEmailCertUseCase {
    private final CreateEmailCertPort createEmailCertPort;
    private final SendEmailPort sendEmailPort;

    @Override
    public EmailCert createEmailCert(CreateEmailCertCommand command) {
        String uuid = UUID.randomUUID().toString();

        EmailCert emailCert = EmailCert.builder()
                .email(command.getEmail())
                .uuid(uuid)
                .build();

        EmailCertJpaEntity emailCertJpaEntity = createEmailCertPort.createEmailCert(emailCert);

        sendEmailPort.sendEmail(emailCert);

        return EmailCert.builder()
                .id(emailCertJpaEntity.getId())
                .email(emailCertJpaEntity.getEmail())
                .uuid(emailCertJpaEntity.getUuid())
                .build();
    }
}
