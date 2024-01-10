package com.example.hexagonalarchitecture.member.adapter.in.web;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class ModifyMemberRequest {
    @NotNull
    private String password;

    @NotNull
    private String nickname;

    private Boolean status;
}
