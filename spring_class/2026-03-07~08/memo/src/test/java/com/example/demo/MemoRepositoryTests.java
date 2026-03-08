package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;

@SpringBootTest
public class MemoRepositoryTests {

	@Autowired
	private MemoRepository memoRepository;
	
	// insert
//	@Test
	public void testInsert() {
		IntStream.rangeClosed(1, 100).forEach(i ->{
			Memo memo = Memo.builder()
					.memoText("Memo " + i)
					.build();
			memoRepository.save(memo);
		});
    }
	
	// 전체 조회
//	@Test
	public void testFindAll() {
		List<Memo> list = memoRepository.findAll();
		
		list.forEach(memo -> {
			System.out.println(memo);
		});
	}
	
	
	// 한 개 조회
//	@Test
	public void testFindById() {
		
		Long id = 1L;
		Optional<Memo> result = memoRepository.findById(id);
		
		if(result.isPresent()) {
			Memo memo = result.get();
			System.out.println(memo);
		}
	}
	
	// 삭제
	@Test
	public void testDelete() {
		Long id = 100L;
		memoRepository.deleteById(id);
		
	}
	
}
