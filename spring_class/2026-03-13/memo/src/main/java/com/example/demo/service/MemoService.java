package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Memo;

public interface MemoService {
	void register(String memoText);
	List<Memo> getList();
	Memo get(Long id);
	void modify(Long id, String memoText);
	void remove(Long id);
}
