package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Board;
import com.example.demo.entity.Reply;

import jakarta.transaction.Transactional;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
	
	@Modifying
	@Query("Delete from Reply r where r.board.bno =:bno")
	void deleteByBno(@Param("bno") Long bno);
	
	// 게시물 기준으로 댓글 목록 가져오기 작성하기.. 아래는 쿼리 메서드를 사용한 예시
	@Transactional
	List<Reply> getRepliesByBoardOrderByRno(Board board);
	
}
