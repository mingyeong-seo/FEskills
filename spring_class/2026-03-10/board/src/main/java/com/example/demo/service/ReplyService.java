package com.example.demo.service;

import java.util.List;

import com.example.demo.dtos.ReplyDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Reply;

/*
 * 댓글을 등록, 특정 게시물의 댓글을 get, 댓글 수정하고 삭제하는 기능
 * entity -> Dto 변환, DTO -> entity 변환 기능 정의
 */

public interface ReplyService {
	Long register(ReplyDTO replyDTO);
	
	List<ReplyDTO> getList(Long bno);
	
	void modify(ReplyDTO replyDTO);
	void remove(Long rno);
	
	default ReplyDTO entityToDTO(Reply reply) {
		ReplyDTO dto = ReplyDTO.builder()
				.rno(reply.getRno())
				.text(reply.getText())
				.replyer(reply.getReplyer())
				.regDate(reply.getRegDate())
				.modDate(reply.getModDate())
				.build();
		return dto;
	}
	
	default Reply dtoToEntity(ReplyDTO dto) {
		Board board = Board.builder()
				.bno(dto.getBno()).build();
		
		Reply reply = Reply.builder()
				.rno(dto.getRno())
				.text(dto.getText())
				.replyer(dto.getReplyer())
				.board(board)
				.build();
		
		return reply;
	}
	
}
