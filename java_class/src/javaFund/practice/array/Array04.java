package javaFund.practice.array;

import java.util.Arrays;

public class Array04 {

	public static void main(String[] args) {
		/*
         * [Array-04] 배열 복사
         *
         * 원본 배열:
         * int[] origin = {1, 2, 3};
         *
         * 요구사항:
         * 1) origin을 복사한 새 배열 copy 생성 (크기 동일)
         * 2) for문으로 값 복사
         * 3) copy[0] 값을 100으로 변경
         * 4) origin과 copy 각각 출력
         *
         * 관찰 포인트:
         * - origin 값이 변했는지 확인
         *
         * TODO:
         * - origin = copy 같은 대입은 사용 금지
         */
		int[] origin = {1, 2, 3};
		
		// 같은 크기의 새 배열 생성
		int[] copy = new int[origin.length];
		
		// 값 하나씩 복사
		for(int i = 0; i < origin.length; i++) {
			copy[i] = origin[i];
		}
		
		// copy[0] 값을 100으로 변경
		copy[0] = 100;
		
		System.out.println(Arrays.toString(origin));
		System.out.println(Arrays.toString(copy));
		

	}

}
