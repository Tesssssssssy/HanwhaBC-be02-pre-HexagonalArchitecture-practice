package com.example.hexagonalarchitecture.member.application.port.out;

import com.example.hexagonalarchitecture.member.adapter.out.persistence.MemberJpaEntity;
import com.example.hexagonalarchitecture.member.domain.Member;

public interface RegisterMemberPort {
    // 그림에서 Output port

    MemberJpaEntity createMember(Member member);
}
