package javaFund.practice.lib02_arrays;

import java.util.Arrays;

/*
 * [문제 Arrays-01] Arrays 유틸 실습
 *
 * 목표:
 * - Arrays.toString / Arrays.equals / Arrays.sort 를 써서 결과 확인
 *
 * 준비:
 * int[] a = {3, 1, 2};
 * int[] b = {3, 1, 2};
 *
 * 요구사항:
 * 1) Arrays.toString(a) 출력
 * 2) a == b 출력 (참조 비교)
 * 3) Arrays.equals(a, b) 출력 (값 비교)
 * 4) Arrays.sort(a) 후 Arrays.toString(a) 출력
 *
 * [오라클 문서 확인 포인트]
 * - equals가 "얕은 비교/깊은 비교" 중 무엇인지
 * - sort가 원본 배열을 바꾸는지(부수효과)
 */

public class Arrays_01_ToStringEqualsSort {
	public static void main(String[] args) {
		int[] a = { 3, 1, 2 };
		int[] b = { 3, 1, 2 };
		String toStringResult = Arrays.toString(a);
		System.out.println(toStringResult);
		System.out.println(a == b);
		System.out.println(Arrays.equals(a, b));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

	}
}