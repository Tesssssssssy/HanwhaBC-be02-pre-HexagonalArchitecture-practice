package com.example.hexagonalarchitecture.member.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
    // domain 임.
    // Entity 아님!!!!!!!

    private final Long id;
    private final String email;
    private final String password;
    private final String nickname;
    private final Boolean status;
}
