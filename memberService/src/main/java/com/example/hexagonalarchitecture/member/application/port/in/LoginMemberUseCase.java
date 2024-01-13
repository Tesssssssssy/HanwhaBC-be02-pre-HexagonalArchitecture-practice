package com.example.hexagonalarchitecture.member.application.port.in;

import com.example.hexagonalarchitecture.member.domain.JwtToken;

public interface LoginMemberUseCase {
    JwtToken loginMember(LoginMemberCommand command);
}
