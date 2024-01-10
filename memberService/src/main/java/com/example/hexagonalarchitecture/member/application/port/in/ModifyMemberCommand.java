package com.example.hexagonalarchitecture.member.application.port.in;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModifyMemberCommand {
    private final String password;
    private final String nickname;
    private final Boolean status;

    public ModifyMemberCommand(String password, String nickname, Boolean status) {
        this.password = password;
        this.nickname = nickname;
        this.status = status;
    }
}
