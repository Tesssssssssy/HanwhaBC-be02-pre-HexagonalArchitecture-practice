package com.example.hexagonalarchitecture.member.application.service;

import com.example.hexagonalarchitecture.common.UseCase;
import com.example.hexagonalarchitecture.member.application.port.in.VerifyEmailCertCommand;
import com.example.hexagonalarchitecture.member.application.port.in.VerifyEmailCertUseCase;
import com.example.hexagonalarchitecture.member.application.port.out.ModifyMemberPort;
import com.example.hexagonalarchitecture.member.application.port.out.VerifyEmailCertPort;
import com.example.hexagonalarchitecture.member.domain.Member;
import com.example.hexagonalarchitecture.member.domain.VerifyEmailCert;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class VerifyEmailCertService implements VerifyEmailCertUseCase {
   private final VerifyEmailCertPort verifyEmailCertPort;
    private final ModifyMemberPort modifyMemberPort;

    @Override
    public VerifyEmailCert verifyEmailCert(VerifyEmailCertCommand command) {
        VerifyEmailCert verifyEmailCert = VerifyEmailCert.builder()
                .email(command.getEmail())
                .uuid(command.getUuid())
                .build();

        VerifyEmailCert response = verifyEmailCertPort.verifyEmailCert(verifyEmailCert);

        if(response != null) {
            modifyMemberPort.verifyMember(Member.builder()
                    .id(response.getId())
                    .status(true)
                    .build());

            return  verifyEmailCert;
        }
        return null;
    }
}
