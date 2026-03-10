package com.example.demo.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.BoardDTO;
import com.example.demo.dtos.PageRequestDTO;
import com.example.demo.dtos.PageResultDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.ReplyRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository repository;
	private final ReplyRepository replyRepository;

	@Override
	public Long register(BoardDTO dto) {
		Board board = dtoToEntity(dto);
		repository.save(board);
		
		return board.getBno();
	}
	
	// 이 메서드에서는 조회된 entity를 Function 객체를 통해 dto로 변경하도록 만드는 함수를 
	// 작성해서 넘겨야 한다.. 넘기는 대상은 Page 정보를 리턴해주는 PageResult 객체로 넘긴다
	@Override
	public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
		
		// Function 객체 생성하기
		Function<Object[], BoardDTO> fn = (en ->
		entityToDTO((Board)en[0], (Member)en[1], (Long)en[2]));
		
		// 조회된 Page 객체를 얻어내고
		Page<Object[]> result = repository.getBoardWithReplyCount(
				pageRequestDTO.getPageable(Sort.by("bno").descending()));
		
		return new PageResultDTO<>(result, fn);			
	}
	
	@Override
	public BoardDTO get(Long bno) {
		Object result = repository.getBoardByBno(bno);
		Object[] arr = (Object[])result;
		return entityToDTO((Board)arr[0], (Member)arr[1], (Long)arr[2]);
	}
	
	@Transactional
	@Override
	public void removeWithReplies(Long bno) {
		// 댓글부터 삭제한다
		replyRepository.deleteByBno(bno);
		repository.deleteById(bno);
		
	}
	
	@Transactional
	@Override
	public void modify(BoardDTO boardDTO) {
		Board board = repository.getReferenceById(boardDTO.getBno());
		
		board.changeTitle(boardDTO.getTitle());
		board.changeContent(boardDTO.getContent());
		
		repository.save(board);
	}
}
