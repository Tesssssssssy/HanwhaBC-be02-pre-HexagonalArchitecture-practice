package com.example.hexagonalarchitecture.member.application.port.out;

import com.example.hexagonalarchitecture.member.adapter.out.persistence.MemberJpaEntity;
import com.example.hexagonalarchitecture.member.application.port.in.ModifyMemberCommand;
import com.example.hexagonalarchitecture.member.domain.Member;

public interface ModifyMemberPort {
    MemberJpaEntity modifyMember(Member member, Long id);
}
