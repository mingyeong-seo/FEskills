package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_memo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Memo {
	// 엔티티 객체는 반드시 PK를 가지고 있어야 함.,
	@Id //PK임을 선언함
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement로 증가 하라는 의미임
	private Long mno;
	
	// 컬럼을 추가한다
	@Column(length = 200, nullable = false)
	private String memoText;

}
