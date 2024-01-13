package com.example.hexagonalarchitecture.member.adapter.in.web;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.member.application.port.in.RegisterMemberCommand;
import com.example.hexagonalarchitecture.member.application.port.in.RegisterMemberUseCase;
import com.example.hexagonalarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter // 없어도 작동에 문제 없지만 Hexagonal에서 이름을 붙여준 것.
@RestController // 동작은 이 어노테이션이 하는 것.
@RequiredArgsConstructor
public class RegisterMemberController {
    private final RegisterMemberUseCase registerMemberUseCase;

    @PostMapping("/member/signup")
    Member registerMember(@RequestBody RegisterMemberRequest request) {
        RegisterMemberCommand command = RegisterMemberCommand.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .status(false)
                .build();

        return registerMemberUseCase.registerMember(command);
    }
}
