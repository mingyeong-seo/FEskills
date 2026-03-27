package com.example.demo.mallapi.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.mallapi.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	// Member 조회시 Role까지 같이 가져오도록 어노테이션 추가
	@EntityGraph(attributePaths = {"memberRoleList"})
	@Query("Select m from Member m where m.email=:email")
	Member getWithRoles(@Param("email") String email);
	
}