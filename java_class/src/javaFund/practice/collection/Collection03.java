package javaFund.practice.collection;

import java.util.HashSet;
import java.util.Set;

public class Collection03 {

	public static void main(String[] args) {
		/*
		 * [Collection-03] Set 인터페이스
		 *
		 * 목표: - Set은 중복 X, 순서 X
		 *
		 * 요구사항: 1) Set<Integer> 생성 2) 1, 2, 2, 3 추가 3) 전체 출력
		 *
		 * 관찰: - 중복 값이 어떻게 되는지 확인
		 */

		// Set은 인터페이스라서 new Set() 불가, 구현 클래스로 생성해야 함
		Set<Integer> set = new HashSet<>();

		set.add(1);
		set.add(2);
		set.add(2);
		set.add(3);

		System.out.println(set);

	}
}
