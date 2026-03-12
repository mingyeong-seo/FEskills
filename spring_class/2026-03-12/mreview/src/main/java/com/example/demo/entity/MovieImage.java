package com.example.demo.entity;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 영화에 종속되는 이미지 엔티티 설계
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "movie")
public class MovieImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	
	private String uuid; // uuid 사용 계획임
	private String imgName;
	private String path;
	
	// Movie외 1:M 관계 설정
	@ManyToOne(fetch = FetchType.LAZY)
	private Movie movie;
}
