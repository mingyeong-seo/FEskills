package com.example.demo.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
	private Long rno;
	private String text;
	private String replyer;
	private Long bno; // 게시물 번호
	private LocalDateTime regDate, modDate;
}
