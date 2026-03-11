package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.ReplyDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Reply;
import com.example.demo.repository.ReplyRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private final ReplyRepository replyRepository;

	@Override
	public Long register(ReplyDTO replyDTO) {
		Reply reply = dtoToEntity(replyDTO);
		
		replyRepository.save(reply);
		return reply.getRno();
	}

	@Override
	public List<ReplyDTO> getList(Long bno) {
		Board board = Board.builder().bno(bno).build();
		
		List<Reply> result = replyRepository.getRepliesByBoardOrderByRno(board);

		return result.stream().map(reply ->
			entityToDTO(reply)).collect(Collectors.toList());
	}
	
	@Transactional
	@Override
	public void modify(ReplyDTO replyDTO) {
		Optional<Reply> result = replyRepository.findById(replyDTO.getRno());
        
		if(result.isPresent()) {
			Reply reply = result.get();
			reply.changeText(replyDTO.getText());
			reply.changeReplyer(replyDTO.getReplyer());
			replyRepository.save(reply);
		}
	}

	@Override
	public void remove(Long rno) {
		replyRepository.deleteById(rno);

	}

}
