package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dtos.BoardDTO;
import com.example.demo.dtos.PageRequestDTO;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model) {
		model.addAttribute("result", boardService.getList(pageRequestDTO));
	}

	@GetMapping("/register")
	public void register() {
	}

	@PostMapping("/register")
	public String registerPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
		Long bno = boardService.register(boardDTO);

		// boardService.register(boardDTO);

		return "redirect:/board/list";
	}

	@GetMapping({"/read","/modify"})
	public void read(@ModelAttribute("requestDTO") PageRequestDTO requestDTO, @RequestParam("bno") Long bno,
			Model model) {

		BoardDTO dto = boardService.get(bno);
		model.addAttribute("dto", dto);
	}

	
	@PostMapping("/modify")
	public String modify(BoardDTO boardDTO,
	                     @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
	                     RedirectAttributes redirectAttributes) {
	    boardService.modify(boardDTO);
	    
	    redirectAttributes.addAttribute("bno", boardDTO.getBno());
	    redirectAttributes.addAttribute("page", requestDTO.getPage());
	    redirectAttributes.addAttribute("type", requestDTO.getType());
	    redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());
	    
	    return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String delete(@RequestParam("bno") Long bno) {
		boardService.removeWithReplies(bno);
		return "redirect:/board/list";
	}
	
	
}
