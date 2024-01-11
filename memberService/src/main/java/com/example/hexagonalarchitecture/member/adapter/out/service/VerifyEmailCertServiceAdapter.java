package com.example.hexagonalarchitecture.member.adapter.out.service;

import com.example.hexagonalArchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.member.adapter.out.persistence.MemberJpaEntity;
import com.example.hexagonalarchitecture.member.adapter.out.persistence.SpringDataMemberRepository;
import com.example.hexagonalarchitecture.member.application.port.out.VerifyEmailCertPort;
import com.example.hexagonalarchitecture.member.domain.VerifyEmailCert;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class VerifyEmailCertServiceAdapter implements VerifyEmailCertPort {
    private final OpenFeignVerifyEmailCertClient openFeignVerifyEmailCertClient;
    private final SpringDataMemberRepository memberRepository;

    @Override
    public Boolean verifyEmailCert(VerifyEmailCert verifyEmailCert) {
        Boolean response = openFeignVerifyEmailCertClient.call(
                verifyEmailCert.getEmail(), verifyEmailCert.getUuid()
        );
        if (response) {
            Optional<MemberJpaEntity> result = memberRepository.findByEmail(verifyEmailCert.getEmail());
            if (result.isPresent()) {
                MemberJpaEntity memberJpaEntity = result.get();
                memberJpaEntity.setStatus(true);
                memberRepository.save(memberJpaEntity);
            }
        }

        System.out.println(response);
        return response;
    }

}
