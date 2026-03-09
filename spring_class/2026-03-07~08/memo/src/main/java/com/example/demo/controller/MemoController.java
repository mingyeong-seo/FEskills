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


@Controller
public class MemoController {
	@Autowired
	private MemoRepository memoRepository;
	
	// 전체 조회
	@GetMapping("/memo/list")
	public String list(Model model) { // 그래서 String
	    List<Memo> list = memoRepository.findAll();
	    model.addAttribute("list", list);
	    return "memo/list"; //view 이름 반환
	}
	
	// 상세 조회
	@GetMapping("/memo/read")
	public String read(@RequestParam("id") Long id, Model model) {
		Optional<Memo> result = memoRepository.findById(id);
		
		result.ifPresent(memo -> model.addAttribute("memo", memo));
		
		return "memo/read";
	}
	
	// 등록 페이지
	@GetMapping("/memo/register")
	public String register() {
		return "memo/register";
	}
	
	// 등록 처리
	@PostMapping("/memo/register")
	public String registerPost(@RequestParam("memoText") String memoText) {
		Memo memo = Memo.builder()
				.memoText(memoText)
				.build();
		
		memoRepository.save(memo);
		
		return "redirect:/memo/list";
	}
	
	// 삭제
	@GetMapping("memo/remove")
	public String remove(@RequestParam("id") Long id) {
		memoRepository.deleteById(id);
		return "redirect:/memo/list";
	}

	// @GetMapping은 URL path 매핑용이지 쿼리스트링까지 포함해서 쓰는게 아니다
	// ?id=1을 매핑 문자열 안에서 처리하지 않고, 별도로 request parameter 로 처리한다.
			
	// 수정
	@GetMapping("/memo/modify")
	public String modify(@RequestParam("id") Long id, Model model) {
		Optional<Memo> result = memoRepository.findById(id);
		
		result.ifPresent(memo -> model.addAttribute("memo", memo));
		
		return "memo/modify";
	}
	
	// 수정 처리
	@PostMapping("/memo/modify") 
	public String modifyPost(Memo memo) {
		memoRepository.save(memo);
		
		return "redirect:/memo/list";
	}
}
