package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Review;
import com.example.demo.entity.Movie;


public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	// 3번(특정 영화에 대한 정보에는 모든 리뷰의 내용과 회원의 닉네임을 리턴하도록 쿼리 작성)
	List<Review> findByMovie(Movie movie);
}
