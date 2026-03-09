package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

   // join을 이용한 Member 데이터 get..
   // 한 개의 로우내에 실제 데이터인 Object[]로 리턴됨
   @Query("Select b, w from Board b left join b.writer w where b.bno =:bno")
   Object getBoardWithWriter(@Param("bno") Long bno);
   
   // 제목글을 기준으로 댓글 정보를 가져오는 쿼리 작성함
   // 제목글에서 댓글에 join을 거는 형태이기 때문에, 클래스에는 접점이 없음
   // 이런 때에는 쿼리문에 반드시 on을 사용해서 조인을 걸어야 함
   // 0 또는 하나 또는 하나 이상이 리턴되므로, 각 Row는 object[]로 리턴되고, 이를 List로 담아서 리턴함
   @Query("Select b,r from Board b Left Join Reply r On r.board = b where b.bno =:bno")
   List<Object[]> getBoardWithReply(@Param("bno") Long bno);
   
   // list 페이지에 뿌려질 목록을 구성하는 쿼리를 작성하려 함..
   // 목록은 board의 내용 및 작성자의 모든 내용, 그리고 댓글이 존재한다면 댓글의 수를 가져오는 쿼리임..
   @Query(value = "Select b,w, count(r) from Board b "
         + "Left join b.writer w Left Join Reply r On r.board = b Group by b",
         countQuery = "Select count(b) from Board b")
   Page<Object[]> getBoardWithReplyCount(Pageable pageable);   // 목록 화면에 필요한 쿼리
   
   // 글 상세에 필요한 쿼리 작성하기 bno를 기준으로 글의 상세 내용과 작성자, 그리고 댓글의 갯수를 
   // 리턴하도록 쿼리를 작성해보자
   @Query("select b, w, count(r) from Board b "
		     + "left join b.writer w "
		     + "left join Reply r on r.board = b "
		     + "where b.bno = :bno "
		     + "group by b")
		Object getBoardByBno(@Param("bno") Long bno);
   
}