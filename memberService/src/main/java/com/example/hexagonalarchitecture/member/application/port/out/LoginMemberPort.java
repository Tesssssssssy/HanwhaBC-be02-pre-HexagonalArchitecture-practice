package com.example.hexagonalarchitecture.member.application.port.out;


import com.example.hexagonalarchitecture.member.domain.Member;

public interface LoginMemberPort {

    String generateAccessToken(Member member);
    String generateRefreshToken(Member member);


    boolean validateToken(String token);
    String parseMemberIdFromToken(String token);
}
