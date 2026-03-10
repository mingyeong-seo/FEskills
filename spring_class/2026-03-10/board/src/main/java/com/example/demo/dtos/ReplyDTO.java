package com.example.demo.dtos;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReplyDTO {
	private Long rno;
	private String text;
	private String replyer;
	private Long bno; // 게시물 번호
	private LocalDateTime regDate, modDate;
}
