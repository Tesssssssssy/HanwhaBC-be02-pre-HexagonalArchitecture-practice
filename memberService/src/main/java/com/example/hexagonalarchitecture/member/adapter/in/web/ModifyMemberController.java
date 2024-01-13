package com.example.hexagonalarchitecture.member.adapter.in.web;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.member.application.port.in.ModifyMemberCommand;
import com.example.hexagonalarchitecture.member.application.port.in.ModifyMemberUseCase;
import com.example.hexagonalarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMemberController {
    private final ModifyMemberUseCase modifyMemberUseCase;

    @PutMapping("/member/modify/{id}")
    Member modifyMember(@RequestBody ModifyMemberRequest request, @PathVariable Long id) {
        ModifyMemberCommand command = ModifyMemberCommand.builder()
                .password(request.getPassword())
                .nickname(request.getNickname())
                .status(request.getStatus())
                .build();

        return modifyMemberUseCase.modifyMember(command, id);
    }
}
