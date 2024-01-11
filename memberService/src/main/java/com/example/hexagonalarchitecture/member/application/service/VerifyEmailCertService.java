package com.example.hexagonalarchitecture.member.application.service;

import com.example.hexagonalArchitecture.common.UseCase;
import com.example.hexagonalarchitecture.member.application.port.in.VerifyEmailCertCommand;
import com.example.hexagonalarchitecture.member.application.port.in.VerifyEmailCertUseCase;
import com.example.hexagonalarchitecture.member.application.port.out.VerifyEmailCertPort;
import com.example.hexagonalarchitecture.member.domain.VerifyEmailCert;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class VerifyEmailCertService implements VerifyEmailCertUseCase {
   private final VerifyEmailCertPort verifyEmailCertPort;

    @Override
    public Boolean verifyEmailCert(VerifyEmailCertCommand command) {
        VerifyEmailCert verifyEmailCert = VerifyEmailCert.builder()
                .email(command.getEmail())
                .uuid(command.getUuid())
                .build();

        Boolean response = verifyEmailCertPort.verifyEmailCert(verifyEmailCert);

        return response;
    }
}
