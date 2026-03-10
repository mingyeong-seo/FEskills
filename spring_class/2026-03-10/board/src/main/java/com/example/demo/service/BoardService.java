package com.example.demo.service;


import com.example.demo.dtos.BoardDTO;
import com.example.demo.dtos.PageRequestDTO;
import com.example.demo.dtos.PageResultDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

public interface BoardService {
	
	// 수정 메서드 산안
	void modify(BoardDTO boardDTO);
	
	// 삭제 메서드 선언
	void removeWithReplies(Long bno);
	
	// 글 상세에 필요한 메소드 선언
	BoardDTO get(Long bno);
	
	// list 페이지에서 필요한 목록 메서드 선언
	PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDto);
	
	Long register(BoardDTO dto);
	
	// dto -> Entity 변환 메서드 정의 
	default Board dtoToEntity(BoardDTO dto) {
		Member member = Member.builder()
				.email(dto.getWriterEmail()).build();
		
		Board board = Board.builder()
				.bno(dto.getBno())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(member)
				.build();
		return board;
	}
	
	// entity -> dto 변환 메서드 정의 
	/*
	 * 이 메서드에는 세 개의 파라미터 정보가 필요하다
	 * 1. Board 객체 정보
	 * 2. Member 정보
	 * 3. 댓글 개수 정보
	 * 
	 * 위 3개의 정보를 추출해서 파라미터로 던지면, 해당 BoardDTO 객체로 변환해서 서비스 계층으로 전달해야 한다
	 */
	default BoardDTO entityToDTO(Board  board, Member member, Long replyCount) {
		BoardDTO boardDTO = BoardDTO.builder()
				.bno(board.getBno())
				.title(board.getTitle())
				.content(board.getContent())
				.regDate(board.getRegDate())
				.modDate(board.getModDate())
				.writerEmail(member.getEmail())
				.writerName(member.getName())
				.replyCount(replyCount.intValue())
				.build();
		return boardDTO;
	}
}
