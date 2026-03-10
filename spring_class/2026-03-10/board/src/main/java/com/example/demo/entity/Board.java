package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Board extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	private String title;
	private String content;
	
	// FetchType의 Eager는 항상 Join을 해서 연관된 객체(테이블)의 데이터를 조인해서 가져온다
	// lazy는 반대다.
	@ManyToOne(fetch = FetchType.LAZY) //pk를 fk로 참조한다
	private Member writer;
	
	public void changeTitle(String title) {
		this.title = title;
	}
	
	public void changeContent(String content) {
		this.content = content;
	}
}
