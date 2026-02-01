package javaFund.practice.controlflow.ifelse;

public class IfElse02 {

	public static void main(String[] args) {
		/*
		 * [IfElse-02] 윤년 판별
		 *
		 * 입력: - int year
		 *
		 * 윤년 규칙: 
		 * - 4로 나누어떨어지면 윤년 후보 
		 * - 단, 100으로 나누어떨어지면 평년 
		 * - 단, 400으로 나누어떨어지면 윤년
		 *
		 * 출력: - "LEAP" 또는 "COMMON"
		 *
		 * TODO: 1) year 테스트 값 여러 개로 바꿔가며 확인 (예: 2000, 1900, 2024, 2023) 2) 조건식을 실수 없이
		 * 구성
		 */

		int year = 2000;
		
		if (year % 400 == 0) {
			System.out.println("LEAP");
		} else if (year % 100 == 0) {
			System.out.println("COMMON");
		} else if (year % 4 == 0) {
			System.out.println("LEAP");
		} else {
			System.out.println("COMMON");
		}

	}

}
