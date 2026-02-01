package javaFund.practice.controlflow.ifelse;

public class IfElse03 {

	public static void main(String[] args) {
		/*
         * [IfElse-03] 요금 계산 (조건 중첩)
         *
         * 입력:
         * - int age
         * - boolean isStudent
         *
         * 요금 규칙(예시):
         * - 기본요금 1500원
         * - age <= 7  : 무료
         * - age >= 65 : 50% 할인
         * - 그 외:
         *   - 학생이면 20% 할인
         *   - 학생 아니면 할인 없음
         *
         * 출력:
         * - "fee=____"
         *
         * TODO:
         * 1) age, isStudent 테스트 케이스 여러 개 만들기
         * 2) 조건 우선순위가 꼬이지 않게 if/else 구조 짜기
         */
		
		int age = 7;
		int fee = 1500;
		boolean isStudent = false;
		
		if (age <= 7) {
            System.out.println("fee=" + 0);
            return;
        }

        if (age >= 65) {
            System.out.println("fee=" + (fee / 2)); // 1500의 50% = 750
            return;
        }
        
        if (isStudent) {
            System.out.println("fee=" + (fee * 80 / 100));
        } else {
            System.out.println("fee=" + fee);
        }

	}

}
