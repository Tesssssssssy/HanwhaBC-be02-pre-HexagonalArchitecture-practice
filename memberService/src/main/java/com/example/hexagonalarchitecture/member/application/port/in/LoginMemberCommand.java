package com.example.hexagonalarchitecture.member.application.port.in;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public
class LoginMemberCommand {
    private final String email;
    private final String password;

}