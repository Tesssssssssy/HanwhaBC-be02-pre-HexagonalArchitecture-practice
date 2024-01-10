package com.example.hexagonalarchitecture.member.application.port.in;

import com.example.hexagonalarchitecture.member.domain.Member;

public interface ModifyMemberUseCase {
    // input port

    Member modifyMember(ModifyMemberCommand command, Long id);
}
