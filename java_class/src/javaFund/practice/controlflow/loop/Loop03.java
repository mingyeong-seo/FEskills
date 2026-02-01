package javaFund.practice.controlflow.loop;

public class Loop03 {

	public static void main(String[] args) {
		/*
		 * [Loop-03] 첫 번째 배수 찾기
		 *
		 * 입력: - int n
		 *
		 * 규칙: - 1부터 100까지 반복 - n의 배수를 처음 발견하면 즉시 종료
		 *
		 * 출력: - "found=____" - n <= 0 이면 "INVALID"
		 *
		 * TODO: 1) n 유효성 검사 2) for문 1~100 3) 배수 발견 시 저장 + break 4) 결과 출력
		 */

		int n = 3;
		int found = 0;

		if (n <= 0) {
			System.out.println("INVALID");
			return;
		}

		for (int i = 1; i <= 100; i++) {
			if (i % n == 0) {
				found = i;
				break;
			}
		}

		System.out.println("found=" + found);

	}

}
