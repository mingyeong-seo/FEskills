package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;
import com.example.demo.service.MemoService;


@Controller
public class MemoController {
	@Autowired
	private MemoRepository memoRepository;
	
	@Autowired
	private MemoService memoService;
	
	// 전체 조회
	@GetMapping("/memo/list")
	public void list(Model model) { 
	    model.addAttribute("list",memoService.getList());
	}
	
	// 상세 조회
	@GetMapping("/memo/read")
	public void read(@RequestParam("id") Long id, Model model) {
		model.addAttribute("memo", memoService.get(id));
	}
	
	// 등록 페이지
	@GetMapping("/memo/register")
	public void register() {
	}
	
	// 등록 처리
	@PostMapping("/memo/register")
	public String registerPost(@RequestParam("memoText") String memoText) {
		memoService.register(memoText);
		return "redirect:/memo/list";
	}
	
	// 삭제
	@GetMapping("/memo/remove")
	public String remove(@RequestParam("id") Long id) {
		memoService.remove(id);
		return "redirect:/memo/list";
	}
	
	// 수정 페이지 이동
	@GetMapping("/memo/modify")
	public void modify(@RequestParam("id") Long id, Model model) {
		Optional<Memo> result = memoRepository.findById(id);
		
		if(result.isPresent()) {
			model.addAttribute("memo", result.get());
		}
	}
	
	// 수정 처리
	@PostMapping("/memo/modify")
	public String modifyPost(@RequestParam("id") Long id,
	                         @RequestParam("memoText") String memoText) {
		memoService.modify(id, memoText);
		return "redirect:/memo/list";
	}

	
}
