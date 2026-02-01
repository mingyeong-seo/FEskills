package javaFund.practice.array;

public class Array02 {

	public static void main(String[] args) {
		/*
         * [Array-02] 배열에서 조건에 맞는 값만 합산
         *
         * 배열:
         * int[] nums = {3, 7, 10, 15, 20};
         *
         * 요구사항:
         * - 배열에서 "짝수만" 골라서 합 구하기
         *
         * 출력:
         * - "sum=____"
         *
         * TODO:
         * - for문 + if 사용
         * - continue 사용해도 좋음
         */
		
		int[] nums = {3, 7, 10, 15, 20};
		int sum = 0;
		
		for(int i = 0; i < nums.length;i++) {
			if(nums[i] % 2 == 0) {
				sum += nums[i];
			}
		}
		
		System.out.println("sum="+sum);
	}

}
