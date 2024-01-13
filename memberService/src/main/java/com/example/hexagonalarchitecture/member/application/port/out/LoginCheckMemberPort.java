package com.example.hexagonalarchitecture.member.application.port.out;


import com.example.hexagonalarchitecture.member.adapter.out.persistence.MemberJpaEntity;
import com.example.hexagonalarchitecture.member.domain.Member;

public interface LoginCheckMemberPort {
    MemberJpaEntity loginMember(Member member);
}
