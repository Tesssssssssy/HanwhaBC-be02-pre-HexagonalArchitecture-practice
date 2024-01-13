package com.example.hexagonalarchitecture.member.adapter.out.service;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.member.application.port.out.VerifyEmailCertPort;
import com.example.hexagonalarchitecture.member.domain.VerifyEmailCert;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class VerifyEmailCertServiceAdapter implements VerifyEmailCertPort {
    private final OpenFeignVerifyEmailCertClient openFeignVerifyEmailCertClient;
    private final CircuitBreakerFactory circuitBreakerFactory;
    @Override
    public VerifyEmailCert verifyEmailCert(VerifyEmailCert verifyEmailCert) {
//        VerifyEmailCert response = openFeignVerifyEmailCertClient.call(verifyEmailCert.getEmail(), verifyEmailCert.getUuid());
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("verifyEmailCert");

        VerifyEmailCert response = circuitBreaker.run(() -> openFeignVerifyEmailCertClient.call(
                verifyEmailCert.getEmail(), verifyEmailCert.getUuid()
        ), throwable -> null);

        return response;
    }
}
