package javaFund.practice;

import java.util.Scanner;

public class Condition_01_PositiveNegative {

	public static void main(String[] args) {
		/* [문제 1]
		 * 정수 하나를 입력받아
		 * 양수 / 음수 / 0 인지 판별하시오.
		 * 
		 * 제한 조건:
		 * - if / else if / else 만 사용
		 */

		 // 입력값: 정수 하나 (int num)
		 // 처리 조건:
		 //   - num > 0  → 양수
		 //   - num < 0  → 음수
		 //   - num == 0 → 0
		 // 출력 결과:
		 //   - "양수입니다" / "음수입니다" / "0입니다" 출력

		boolean isInt = false;
		int num = 0;

		Scanner sc = new Scanner(System.in);

		while (!isInt) {
			System.out.print("정수 하나 입력: ");

			if (sc.hasNextInt()) {
				num = sc.nextInt();
				isInt = true;
			} else {
				sc.next();
				System.out.println("정수만 입력하세요.");
			}
		}

		if (num > 0) {
			System.out.println("양수입니다.");
		} else if (num == 0) {
			System.out.println("0 입니다.");
		} else {
			System.out.println("음수입니다.");
		}

		sc.close();
	}
}
