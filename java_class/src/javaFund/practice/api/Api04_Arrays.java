package javaFund.practice.api;

import java.util.Arrays;

public class Api04_Arrays {

	public static void main(String[] args) {
		/*
	     * [API-04] Arrays 유틸
	     *
	     * 배열:
	     * int[] nums = {5, 1, 4, 2, 3};
	     *
	     * 요구사항:
	     * 1) 배열 오름차순 정렬
	     * 2) 배열 전체 출력
	     *
	     * TODO:
	     * - Arrays.sort()
	     * - Arrays.toString()
	     */
		int[] nums = {5, 1, 4, 2, 3};
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
