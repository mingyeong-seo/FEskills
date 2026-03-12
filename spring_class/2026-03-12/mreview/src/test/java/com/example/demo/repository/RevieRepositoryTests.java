package com.example.demo.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.mockito.plugins.MemberAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;
import com.example.demo.entity.Movie;
import com.example.demo.entity.Review;

@SpringBootTest
public class RevieRepositoryTests {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
//	@Test
	public void insertReview() {
		// 200개의 리뷰 등록함
		IntStream.rangeClosed(1, 200).forEach(i->{
			// 영화 번호
			Long mno = (long)(Math.random() * 100) + 1;
			
			// 리뷰어 번호
			Long mid = ((long)Math.random()*100+1);
			
			Member member = Member.builder().mid(mid).build();
			
			Review movieReview = Review.builder()
					.member(member)
					.movie(Movie.builder().mno(mno).build())
					.grade((int)(Math.random()*5)+1)
					.text("영화에 대한 짧은 리뷰..."+i)
					.build();
			
			reviewRepository.save(movieReview);
		});
	}
	
	
}
