package com.example.hexagonalarchitecture.member.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyEmailCert {
    private final Long id;
    private final String email;
    private final String uuid;
}
