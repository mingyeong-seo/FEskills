package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService {
	
	private final MemoRepository memoRepository;
	
	@Override
	public void register(String memoText) {
		Memo memo = Memo.builder()
				.memoText(memoText)
				.build();
		
		memoRepository.save(memo);
	}

	@Override
	public List<Memo> getList() {
		List<Memo> result = memoRepository.findAll();
		return result;
	}

	@Override
	public Memo get(Long id) {
		Optional<Memo> result = memoRepository.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public void modify(Long id, String memoText) {
		Optional<Memo> result = memoRepository.findById(id);
		
		if(result.isPresent()) {
			Memo memo = result.get();
			memo.changeMemoText(memoText);
			memoRepository.save(memo);
		}
	}

	@Override
	public void remove(Long id) {
		memoRepository.deleteById(id);
	}

}
