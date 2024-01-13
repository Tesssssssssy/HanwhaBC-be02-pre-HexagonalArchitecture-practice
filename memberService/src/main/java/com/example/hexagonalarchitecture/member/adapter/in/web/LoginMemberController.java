package com.example.hexagonalarchitecture.member.adapter.in.web;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.member.application.port.in.LoginMemberCommand;
import com.example.hexagonalarchitecture.member.application.port.in.LoginMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class LoginMemberController {
    private final LoginMemberUseCase loginMemberUseCase;

    @PostMapping(path = "/member/login")
    ResponseEntity<Object> loginByMember(@RequestBody LoginMemberRequest request) {
        LoginMemberCommand command = LoginMemberCommand.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        return ResponseEntity.ok().body(loginMemberUseCase.loginMember(command));
    }

    @PostMapping(path = "/member/auth/")
    ResponseEntity<Object> authByToken() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
