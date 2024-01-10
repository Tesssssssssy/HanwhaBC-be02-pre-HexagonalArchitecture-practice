package com.example.hexagonalarchitecture.member.adapter.in.web;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterMemberRequest {
    private String email;
    private String password;
    private String nickname;
}
