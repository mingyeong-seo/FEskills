package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ReplyDTO;
import com.example.demo.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RestController // REST API 로 동작하는 서버로 선언함
@RequestMapping("/replies/")
@RequiredArgsConstructor
public class ReplyController {
	private final ReplyService replyService;
	
	 // Get 요청이 왔을때, path variable 형태로 요청을 받고, 이 요청에 응답으로 JSON을 리턴해준다
	@GetMapping(value = "/board/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("bno") Long bno){
		return new ResponseEntity<>(replyService.getList(bno), HttpStatus.OK);
	}
	
	// 댓글 등록 요청 처리 
	@PostMapping("")
	public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO){
		Long rno = replyService.register(replyDTO);
		System.out.println("---------->>>"+replyDTO);
		
		return new ResponseEntity<>(rno, HttpStatus.OK);
	}
	
	// 댓글 삭제 처리.. path variable 을 이용한 요청 처리 
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		replyService.remove(rno);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	// 댓글 수정 처리.. 
	@PutMapping("/{rno}")
	public ResponseEntity<Long> modify(@PathVariable("rno") Long rno, @RequestBody ReplyDTO replyDTO){
		replyDTO.setRno(rno);
			
		replyService.modify(replyDTO);
		return new ResponseEntity<>(rno, HttpStatus.OK);
	}
	
}
