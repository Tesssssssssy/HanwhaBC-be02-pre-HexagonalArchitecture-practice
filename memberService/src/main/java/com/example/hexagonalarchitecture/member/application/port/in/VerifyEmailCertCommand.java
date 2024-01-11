package com.example.hexagonalarchitecture.member.application.port.in;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyEmailCertCommand {
    @NotNull
    private final String email;

    @NotNull
    private final String uuid;
}
