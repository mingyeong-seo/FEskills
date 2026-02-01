package javaFund.practice.array;

import java.util.Arrays;

public class Array05 {

	public static void main(String[] args) {
		/*
         * [Array-05] 향상된 for문 사용
         *
         * 배열:
         * String[] names = {"Kim", "Lee", "Park"};
         *
         * 요구사항:
         * 1) 향상된 for문으로 모든 이름 출력
         * 2) 일반 for문과 비교해 차이 느껴보기
         *
         * TODO:
         * - 인덱스 접근 없이 출력
         */
		
		String[] names = {"Kim", "Lee", "Park"};
		
		
		for(String name : names) {
			System.out.println(name);
		}
        

	}

}
