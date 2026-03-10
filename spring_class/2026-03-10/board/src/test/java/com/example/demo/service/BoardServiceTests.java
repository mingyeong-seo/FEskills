package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dtos.BoardDTO;
import com.example.demo.dtos.PageRequestDTO;
import com.example.demo.dtos.PageResultDTO;

import jakarta.transaction.Transactional;

@SpringBootTest

public class BoardServiceTests {

	@Autowired
	private BoardService boardService;

//  @Test
	public void testRegister() {
		BoardDTO dto = BoardDTO.builder().title("test").content("Test..").writerEmail("user77@aaa.com").build();

		Long bno = boardService.register(dto);
	}

//   @Test
	public void testGetList() {
		PageRequestDTO pageRequestDTO = new PageRequestDTO();

		PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

		for (BoardDTO boardDTO : result.getDtoList()) {
			System.out.println(boardDTO);
		}
	}

	// 글 상세 가져오기
//	@Test
	public void testGet() {

		Long bno = 100L;

		BoardDTO boardDTO = boardService.get(bno);

		System.out.println(boardDTO);

	}

//	@Test
	public void testRemove() {
		Long bno = 100L; 

		boardService.removeWithReplies(bno);

		System.out.println("삭제 완료: " + bno);
	}
	
	
	@Test
	public void testModify() {
	    BoardDTO boardDTO = BoardDTO.builder()
	            .bno(1L)
	            .title("변경된 제목")
	            .content("변경된 내용")
	            .build();

	    boardService.modify(boardDTO);
	}
}