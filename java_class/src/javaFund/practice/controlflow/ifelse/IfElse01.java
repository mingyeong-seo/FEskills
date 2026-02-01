package javaFund.practice.controlflow.ifelse;

public class IfElse01 {

	public static void main(String[] args) {
		/*
		 * [IfElse-01] 점수 등급 계산기
		 *
		 * 입력: - int score (0~100)
		 *
		 * 출력 규칙: - 90~100: "A" - 80~89 : "B" - 70~79 : "C" - 60~69 : "D" - 0~59 : "F" -
		 * 범위 밖이면: "INVALID"
		 *
		 * TODO: 1) score 변수를 하나 선언해서 테스트 값 넣기 (예: 105, -3, 100, 83...) 2) if - else if
		 * - else 로 등급 문자열 grade 계산 3) grade 출력
		 */

		int score = 79;
		char grade;

		if (score < 0 || score > 100) {
			System.out.println("INVALID");
			return;
		}

		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		System.out.println(grade);

	}

}
