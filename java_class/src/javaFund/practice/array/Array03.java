package javaFund.practice.array;

public class Array03 {

	public static void main(String[] args) {
		/*
		 * [Array-03] 배열에서 최대값 찾기
		 *
		 * 배열: int[] scores = {70, 85, 90, 60, 88};
		 *
		 * 요구사항: 1) 배열에서 가장 큰 값 max 구하기 2) max 출력
		 *
		 * 출력: - "max=____"
		 *
		 * TODO: - max 초기값을 "임의의 숫자"로 두지 말 것 - 배열의 첫 번째 값 기준으로 시작할 것
		 */
		int[] scores = { 70, 85, 90, 60, 88 };
		int max = scores[0];

		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		System.out.println("max=" + max);

	}

}
