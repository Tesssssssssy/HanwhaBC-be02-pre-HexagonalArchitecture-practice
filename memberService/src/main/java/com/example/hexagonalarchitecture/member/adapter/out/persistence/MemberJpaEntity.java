package com.example.hexagonalarchitecture.member.adapter.out.persistence;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberJpaEntity {
    // MemberJpaEntity가 우리가 알던 Entity
    // db에 저장해야 하니까 영속성에 entity 만든다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String nickname;
    private Boolean status;
}
