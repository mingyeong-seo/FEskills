package javaFund.practice;

import java.util.Scanner;

public class Condition_03_Age {

	public static void main(String[] args) {
		/*
		 * [문제 3] 나이를 입력받아 미성년자 / 성인을 판별하시오.
		 */

		// 입력값: int age
		// 처리 조건:
		// age > 19 -> "성인"
		// age <= 19 -> "미성년자"
		// 출력 결과: "성인입니다.", "미성년자입니다." 출력

		// TODO: 문제 3 코드 작성

		boolean isAge = false;
		int age = 0;

		Scanner sc = new Scanner(System.in);

		while (!isAge) {
			System.out.print("나이를 입력하세요: ");
			if (sc.hasNextInt()) {
				age = sc.nextInt();
				if (age < 1) {
					continue;
				}
				isAge = true;
			} else {
				sc.next();
				continue;
			}
		}

		if (age > 19) {
			System.out.println("성인입니다.");
		} else {
			System.out.println("미성년자입니다.");
		}
		sc.close();

	}

}
