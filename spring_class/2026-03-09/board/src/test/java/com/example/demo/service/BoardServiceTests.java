package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dtos.BoardDTO;

@SpringBootTest

public class BoardServiceTests {

   @Autowired
   private BoardService boardService;
   
   @Test
   public void testRegister() {
      BoardDTO dto = BoardDTO.builder()
            .title("test")
            .content("Test..")
            .writerEmail("user77@aaa.com")
            .build();
      
      Long bno = boardService.register(dto);
   }
   
}