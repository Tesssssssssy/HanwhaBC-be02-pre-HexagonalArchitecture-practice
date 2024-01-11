package com.example.hexagonalarchitecture.member.application.port.out;

import com.example.hexagonalarchitecture.member.domain.Member;

public interface CreateEmailCertEventPort {
    void createEmailCertEvent(Member member);
}
