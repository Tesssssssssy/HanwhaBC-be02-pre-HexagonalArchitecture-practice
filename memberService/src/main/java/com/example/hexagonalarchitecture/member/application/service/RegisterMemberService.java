package com.example.hexagonalarchitecture.member.application.service;

import com.example.hexagonalArchitecture.common.UseCase;
import com.example.hexagonalarchitecture.member.adapter.out.persistence.MemberJpaEntity;
import com.example.hexagonalarchitecture.member.application.port.in.RegisterMemberCommand;
import com.example.hexagonalarchitecture.member.application.port.in.RegisterMemberUseCase;
import com.example.hexagonalarchitecture.member.application.port.out.CreateEmailCertEventPort;
import com.example.hexagonalarchitecture.member.application.port.out.RegisterMemberPort;
import com.example.hexagonalarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;

//@Service
@UseCase
@RequiredArgsConstructor
public class RegisterMemberService implements RegisterMemberUseCase {
    // Use Case

    private final RegisterMemberPort registerMemberPort;
    private final CreateEmailCertEventPort emailCertEventPort;

    @Override
    public Member registerMember(RegisterMemberCommand command) {
        Member member = Member.builder()
                .email(command.getEmail())
                .password(command.getPassword())
                .nickname(command.getNickname())
                .status(command.getStatus())
                .build();

        MemberJpaEntity memberJpaEntity = registerMemberPort.createMember(member);
        emailCertEventPort.createEmailCertEvent(member);


        return Member.builder()
                .id(memberJpaEntity.getId())
                .email(memberJpaEntity.getEmail())
                .nickname(memberJpaEntity.getNickname())
                .status(memberJpaEntity.getStatus())
                .build();
    }
}
