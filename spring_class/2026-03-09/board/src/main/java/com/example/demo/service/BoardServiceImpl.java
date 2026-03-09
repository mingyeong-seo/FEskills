package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository repository;
	
	@Override
	public Long register(BoardDTO dto) {
		Board board = dtoToEntity(dto);
		repository.save(board);
		
		return board.getBno();
	}

}
