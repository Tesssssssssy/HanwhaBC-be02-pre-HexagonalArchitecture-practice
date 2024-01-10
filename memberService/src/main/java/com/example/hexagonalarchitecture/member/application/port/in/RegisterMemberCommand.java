package com.example.hexagonalarchitecture.member.application.port.in;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterMemberCommand {
    // 여기서 이메일 검증, 비밀번호 검증 등의 코드를 추가한다. 일단 notnull만 한다.
    // 회원 가입 시 입력 받을 DTO

    @NotNull
    private final String email;

    @NotNull
    private final String password;

    @NotNull
    private final String nickname;

    private final Boolean status;

    public RegisterMemberCommand(@NotNull String email, @NotNull String password, @NotNull String nickname, Boolean status) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.status = status;

        // TODO: 검증하는 코드 추가할 것 (검증하는 부분은 나중에 따로 뺄 것)
    }
}
