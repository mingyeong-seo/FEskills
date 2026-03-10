package com.example.demo.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Reply;


@SpringBootTest
public class ReplyRepositoryTests {
	@Autowired
	private ReplyRepository replyRepository;
	
	// 댓글 테스트 메소드 정의
	@Test
	public void testListByBoard() {
		List<Reply> replyList = replyRepository.getRepliesByBoardOrderByRno(
				Board.builder().bno(95L).build());
		
		replyList.forEach(reply -> {
			System.out.println(reply);
		});
	}
	
	
//	@Test
	public void insertReply() {
		IntStream.rangeClosed(1, 100)
			.forEach( i -> {
				long bno = (long)(Math.random() * 100 + 1);
				Board board = Board.builder().bno(bno).build();
				Reply reply = Reply.builder()
						.text("댓글..."+i)
						.board(board)
						.replyer("guest").build();
				
				replyRepository.save(reply);
				
			});
	}

}
