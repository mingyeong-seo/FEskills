package javaFund.practice;

import java.util.Scanner;

public class Condition_02_Grade {

	public static void main(String[] args) {
		/*
		 * [문제 2] 점수를 입력받아 A/B/C/D/F 학점을 출력하시오.
		 * 
		 * 기준: 90 이상 A 80 이상 B 70 이상 C 60 이상 D 그 외 F
		 */

		// 입력값: int score
		// 처리 조건:
		// score >= 90 -> A
		// score >= 80 -> B
		// score >= 70 -> C
		// score >= 60 -> D
		// else -> F
		// 출력 결과: "학점은 A 입니다.", "학점은 B 입니다.", "학점은 C 입니다.", "학점은 D 입니다.", "학점은 F 입니다."

		// TODO: 문제 2 코드 작성
		
		boolean isScore = false;
		int score = 0;
		char grade = ' ';
		Scanner sc = new Scanner(System.in);
		
		while(!isScore) {
			System.out.print("국어 점수 입력: ");
			if(sc.hasNextInt()) {
				score = sc.nextInt();
				if(score < 0 || score > 100) {
					continue;
				}
				isScore = true;
			} else {
				sc.next();
				continue;
			}
		}
		
		switch(score/10) {
		case 10:
		case 9: grade = 'A'; break;
		case 8: grade = 'B'; break;
		case 7: grade = 'C'; break;
		case 6: grade = 'D'; break;
		default: grade = 'F';
		}
		
		System.out.println("학점은 "+grade+" 입니다.");
		sc.close();
	}

}
