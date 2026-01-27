package javaFund.practice;

import java.util.Scanner;

public class Condition_04_MaxNumber {

	public static void main(String[] args) {
		/*
		 * [문제 4] 정수 2개를 입력받아 더 큰 수를 출력하시오.
		 */

		// 입력값: int num1, num2
		// 처리 조건:
		// num1 > num2 -> num1 출력
		// num1 == num2 -> "같은 수 입니다" 출력
		// Num1 < num2 -> num2 출력
		// 출력 결과: "num1이 더 큰 수 입니다.", "같은 수 입니다", "num2가 더 큰 수 입니다." 출력

		// TODO: 문제 4 코드 작성
		boolean isTwoNumber = false;
		int num1 = 0;
		int num2 = 0;

		Scanner sc = new Scanner(System.in);

		while (!isTwoNumber) {
		    System.out.print("두 정수를 입력하세요 (공백으로 구분): ");

		    if (!sc.hasNextInt()) {
		        sc.next();
		        System.out.println("첫 번째 값은 정수여야 합니다.");
		        continue;
		    }
		    num1 = sc.nextInt();

		    if (!sc.hasNextInt()) {
		        sc.next();
		        System.out.println("두 번째 값은 정수여야 합니다.");
		        continue;
		    }
		    num2 = sc.nextInt();

		    isTwoNumber = true;
		}
		
		if(num1 > num2) {
			System.out.println(num1+"이 더 큰 수 입니다.");
		}else if (num1 == num2) {
			System.out.println("같은 수 입니다");
		}
		else {
			System.out.println(num2+"가 더 큰 수 입니다.");
		}
		sc.close();
	}

}
