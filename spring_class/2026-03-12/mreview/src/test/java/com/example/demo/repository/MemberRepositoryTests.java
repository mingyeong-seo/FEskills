package com.example.demo.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTests {
	// Member 엔티티를 이용해서  m_member 테이블에 아래처럼 100개의 데이터를 넣으시요
	// 이메일 서버명은 @abc.com 으로 하고 비번은 1111, nickname은 reviewer1...100
	// 데이터 밀어넣기 
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void insertMembers() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Member member = Member.builder()
					.email("test" + i + "@abc.com")
	                .pw("1111")
	                .nickname("reviewer" + i)
	                .build();
			memberRepository.save(member);
		});
	}
}
