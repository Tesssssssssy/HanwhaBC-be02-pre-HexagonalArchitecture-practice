package com.example.hexagonalarchitecture.member.application.service;

import com.example.hexagonalArchitecture.common.UseCase;
import com.example.hexagonalarchitecture.member.adapter.out.persistence.MemberJpaEntity;
import com.example.hexagonalarchitecture.member.application.port.in.ModifyMemberCommand;
import com.example.hexagonalarchitecture.member.application.port.in.ModifyMemberUseCase;
import com.example.hexagonalarchitecture.member.application.port.out.ModifyMemberPort;
import com.example.hexagonalarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.IllegalFormatCodePointException;

//@Service
@UseCase
@RequiredArgsConstructor
public class ModifyMemberService implements ModifyMemberUseCase {
    private final ModifyMemberPort modifyMemberPort;

    @Override
    public Member modifyMember(ModifyMemberCommand command, Long id) {
        Member member = Member.builder()
                .password(command.getPassword())
                .nickname(command.getNickname())
                .status(command.getStatus())
                .build();

        MemberJpaEntity memberJpaEntity = modifyMemberPort.modifyMember(member, id);

        return Member.builder()
                .id(memberJpaEntity.getId())
                .email(memberJpaEntity.getEmail())
                .password(member.getPassword())
                .nickname(memberJpaEntity.getNickname())
                .status(memberJpaEntity.getStatus())
                .build();
    }
}
