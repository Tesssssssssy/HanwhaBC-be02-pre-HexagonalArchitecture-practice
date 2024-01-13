package com.example.hexagonalarchitecture.member.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtToken {
    private Long id;
    private String accessToken;
    private String refreshToken;

    public static JwtToken generateJetToken(Long id, String accessToken, String refreshToken){
        return new JwtToken(id, accessToken, refreshToken);
    }
}
