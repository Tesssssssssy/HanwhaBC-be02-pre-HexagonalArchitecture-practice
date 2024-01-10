package com.example.hexagonalarchitecture.member.application.port.in;

import com.example.hexagonalarchitecture.member.domain.Member;

public interface RegisterMemberUseCase {
    // 얘가 사실은 input port
    // naming 중복 때문에 어차피 Use Case를 사용할 애니까 그냥 Use Case라고 이름 지음
    // 근데 input port임.

    Member registerMember(RegisterMemberCommand command);
}
