package com.example.hexagonalarchitecture.member.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMemberRepository extends JpaRepository<MemberJpaEntity, Long> {

}
