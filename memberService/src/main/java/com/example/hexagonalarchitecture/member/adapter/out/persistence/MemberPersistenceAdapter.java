package com.example.hexagonalarchitecture.member.adapter.out.persistence;

import com.example.hexagonalarchitecture.common.PersistenceAdapter;
import com.example.hexagonalarchitecture.member.application.port.out.LoginCheckMemberPort;
import com.example.hexagonalarchitecture.member.application.port.out.ModifyMemberPort;
import com.example.hexagonalarchitecture.member.application.port.out.RegisterMemberPort;
import com.example.hexagonalarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

//@Component
@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements RegisterMemberPort, ModifyMemberPort, LoginCheckMemberPort {
    // 출력 포트의 구현체

    private final SpringDataMemberRepository memberRepository;

    @Override
    public MemberJpaEntity createMember(Member member) {
        return memberRepository.save(
                MemberJpaEntity.builder()
                    .email(member.getEmail())
                    .password(member.getPassword())
                    .nickname(member.getNickname())
                    .status(member.getStatus())
                    .build());
        // entity를 그대로 반환
        // 얘를 Service에서 호출했으니까 Service에서 builder.build
    }

    @Override
    public MemberJpaEntity modifyMember(Member member, Long id) {
        Optional<MemberJpaEntity> result = memberRepository.findById(id);
        if (result.isPresent()) {
            MemberJpaEntity memberJpaEntity = result.get();
            memberJpaEntity.setPassword(member.getPassword());
            memberJpaEntity.setNickname(member.getNickname());
            memberJpaEntity.setStatus(member.getStatus());

            memberJpaEntity = memberRepository.save(memberJpaEntity);
            return memberJpaEntity;
        }
        return null;
    }

    @Override
    public MemberJpaEntity loginMember(Member member) {
        Optional<MemberJpaEntity> result = memberRepository.findByEmail(member.getEmail());

        if(result.isPresent()) {
            MemberJpaEntity entity = result.get();
            if (entity.getPassword().equals(member.getPassword())) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public MemberJpaEntity verifyMember(Member member) {
        MemberJpaEntity memberJpaEntity = memberRepository.getById(member.getId());
        memberJpaEntity.setStatus(member.getStatus());

        return memberRepository.save(memberJpaEntity);
    }

}
