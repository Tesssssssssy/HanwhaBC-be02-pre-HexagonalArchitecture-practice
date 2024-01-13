package com.example.hexagonalarchitecture.member.application.service;

import com.example.hexagonalarchitecture.common.UseCase;
import com.example.hexagonalarchitecture.member.adapter.out.persistence.MemberJpaEntity;
import com.example.hexagonalarchitecture.member.application.port.in.LoginMemberCommand;
import com.example.hexagonalarchitecture.member.application.port.in.LoginMemberUseCase;
import com.example.hexagonalarchitecture.member.application.port.out.LoginCheckMemberPort;
import com.example.hexagonalarchitecture.member.application.port.out.LoginMemberPort;
import com.example.hexagonalarchitecture.member.domain.JwtToken;
import com.example.hexagonalarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class LoginMemberService implements LoginMemberUseCase {
	private final LoginMemberPort loginMemberPort;
	private final LoginCheckMemberPort loginCheckMemberPort;

	@Override
	public JwtToken loginMember(LoginMemberCommand command) {

		// 아이디 비번 확인
		MemberJpaEntity entity = loginCheckMemberPort.loginMember(
				Member.builder()
						.email(command.getEmail())
						.password(command.getPassword())
						.build());

		if(entity != null) {
			Member member = Member.builder()
					.id(entity.getId())
					.email(entity.getEmail())
					.nickname(entity.getNickname())
					.build();


			String accessToken = loginMemberPort.generateAccessToken(member);
			String refreshToken = loginMemberPort.generateRefreshToken(member);

			return JwtToken.generateJetToken(entity.getId(), accessToken, refreshToken);
		}

		return null;
	}
}




