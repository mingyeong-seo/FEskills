package javaFund.practice;

import java.util.Scanner;

public class Condition_05_RockPaperScissors {

	public static void main(String[] args) {
		/*
		 * [문제 5] 가위바위보 게임 (1: 가위, 2: 바위, 3: 보) 컴퓨터와 사용자 값을 비교하여 승/패/무 출력
		 */

		// 입력값: int userVal = 1 or 2 or 3
		// 처리 조건:
		// user == 1 && computer == 3 || user == 2 && computer == 1 || user == 3 &&
		// computer == 2 => 사용자 승
		// user == 1 && computer == 2 || user == 2 && computer == 3 || user == 3 &&
		// computer == 1 => 사용자 패
		// user == 1 && computer == 1 || user == 2 && computer == 2 || user == 3 &&
		// computer == 3 => 무승부
		// 출력 결과: "사용자 승", "사용자 패", "무승부" 출력

		// TODO: 문제 5 코드 작성

		boolean isUser = false;
		int userVal = 0;
		int computer = 0;

		Scanner input = new Scanner(System.in);

		while (!isUser) {
			System.out.print("가위바위보 게임입니다. 1, 2 ,3 중 입력하세요.(1: 가위, 2: 바위, 3: 보): ");
			if (input.hasNextInt()) {
				userVal = input.nextInt();
				if (userVal < 1 || userVal > 3) {
					System.out.println("1~3만 입력하세요.");
					continue;
				}
				isUser = true;
			} else {
				input.next();
			}
		}

		computer = (int) (Math.random() * 3) + 1;

		if (computer == userVal) {
			System.out.println("무승부입니다.");
		} else if ((userVal == 1 && computer == 3) || (userVal == 2 && computer == 1)
				|| (userVal == 3 && computer == 2)) {
			System.out.println("사용자 승");
		} else {
			System.out.println("사용자 패");
		}

		input.close();

	}

}
