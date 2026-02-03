package javaFund.practice.collection;

import java.util.Arrays;
import java.util.List;

public class Collection02 {

	public static void main(String[] args) {
		/*
		 * [Collection-02] List 인터페이스
		 *
		 * 목표: - List는 순서 O, 중복 O
		 *
		 * 요구사항: 1) List<String> 선언 (ArrayList 사용) 2) "A", "B", "A" 추가 3) 전체 출력 4)
		 * size() 출력
		 *
		 * TODO: - 인터페이스 타입으로 선언
		 */

		List<String> list = Arrays.asList("A", "B", "A");

		System.out.println(list);
		System.out.println(list.size());

	}

}
