package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	/*
	 * 아래와 같은 데이터가 필요하다.. 이런 데이터를 얻기 위해서 메서드를 선언하고
	 * JPQL을 이용해서 쿼리를 작성한 후 결과를 되돌린다
	 * 
	 * 1. List 화면에서 영화의 제목과 이미지 하나, 영화의 리뷰의 평점/리뷰 갯수를 출력할 예정임
	 * 2. 영화 조회 화면에서 영화와 영화의 이미지들, 리뷰의 평균점수/리뷰갯수를 출력할 예정임
	 * 3. 특정 영화에 대한 정보에는 모든 리뷰의 내용과 회원의 닉네임을 리턴하도록 쿼리 작성
	 */
	
	@Query("select m, mi, avg(coalesce(r.grade, 0)), count(distinct r) from "
	        + "Movie m left outer join MovieImage mi on mi.movie = m "
	        + "left outer join Review r on r.movie = m group by m")
	Page<Object[]> getListPage(Pageable pageable);
	
	// 2번에 해당하는 쿼리를 작성 후 테스트 해보기 
	@Query("select m, mi, avg(coalesce(r.grade,0)), count(distinct r) from "
	        + "Movie m left outer join MovieImage mi on mi.movie = m "
	        + "left outer join Review r on r.movie = m "
	        + "where m.mno =:mno "
	        + "group by m, mi")
	List<Object[]> getMovieWithAll(@Param("mno") Long mno); 
	
	
	
}
