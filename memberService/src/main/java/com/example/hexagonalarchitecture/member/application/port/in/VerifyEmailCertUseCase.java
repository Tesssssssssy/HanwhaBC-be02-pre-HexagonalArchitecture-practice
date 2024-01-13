package com.example.hexagonalarchitecture.member.application.port.in;


import com.example.hexagonalarchitecture.member.domain.VerifyEmailCert;

public interface VerifyEmailCertUseCase {
    VerifyEmailCert verifyEmailCert(VerifyEmailCertCommand command);
}
