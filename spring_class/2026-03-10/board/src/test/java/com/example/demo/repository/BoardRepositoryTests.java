package com.example.demo.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

import jakarta.transaction.Transactional;

@SpringBootTest
public class BoardRepositoryTests {
	@Autowired
	private BoardRepository boardRepository;
	
//	@Test
	public void testGetBoardByBno() {
		Object result = boardRepository.getBoardByBno(100L);

	    Object[] arr = (Object[]) result;

	    Board board = (Board) arr[0];
	    Member member = (Member) arr[1];
	    Long replyCount = (Long) arr[2];

	    System.out.println(board);
	    System.out.println(member);
	    System.out.println(replyCount);
	}
	
	
//	@Test
	public void testWithReplyCount() {
		Pageable pageable = PageRequest.of(0, 10,Sort.by("bno").descending());
		
		Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);
		
		result.get().forEach(objRow -> {
			Object[] arr = (Object[])objRow;
			System.out.println(arr[0]);
			System.out.println(arr[1]);
			System.out.println(arr[2]);
		//	System.out.println(Arrays.toString(arr));
		});
	}
	
//	@Transactional
//	@Test
	public void testGetBoardWithReply() {
		List<Object[]> result = boardRepository.getBoardWithReply(100L);
		for(Object[] arr: result) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
//	@Test
	public void testReadWithWriter() {
		Object result = boardRepository.getBoardWithWriter(100L);
		
		Object[] arr = (Object[])result;
		
		System.out.println("++++++++++++++++++++++++++");
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	// 특정 글 번호의 글을 조회하도록 한다
	// 이때 실행되는 쿼리를 반드시 확인한다
//	@Transactional
//	@Test
	public void testRead1() {
		Optional<Board> result = boardRepository.findById(100L);
		Board board = result.get();
		
		System.out.println(board);
		System.out.println(board.getWriter());
	}
	
//	@Test
	public void insertBoard() {
		// 게시글에는 작성자가 필요하므로 Member 객체를 먼저 만든 후 작성자에 추가한다.
		IntStream.rangeClosed(1, 100)
			.forEach(i -> {
				Member member = Member.builder()
						.email("user"+i+"@aaa.com")
						.build();
				
				Board board = Board.builder()
						.title("Title..."+i)
						.content("Content..."+i)
						.writer(member)
						.build();
				boardRepository.save(board);
				
			});
		
		
	}
}
