package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
