package javaFund.practice.array;

public class Array01 {

	public static void main(String[] args) {
		/*
         * [Array-01] 배열 선언과 전체 출력
         *
         * 목표:
         * - 배열 선언 방법 익히기
         * - length 사용 익히기
         *
         * 요구사항:
         * 1) int 타입 배열 arr 선언 (크기 5)
         * 2) arr에 10, 20, 30, 40, 50 저장
         * 3) for문으로 모든 요소 출력
         *
         * 출력 예:
         * 10
         * 20
         * 30
         * 40
         * 50
         *
         * TODO:
         * - 인덱스 직접 접근 금지 (arr[0]만 5번 쓰기 ❌)
         */
		
		int[] arr = {10, 20, 30, 40, 50};

		
		for(int i = 0; i < arr.length;i++) {
			System.out.println(arr[i]);
		}

	}

}
