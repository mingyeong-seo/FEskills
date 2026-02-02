package javaFund.practice.interfaceex;

public class Interface01 {

	public static void main(String[] args) {
		/*
		 * [Interface-01] 인터페이스 기본 개념
		 *
		 * 목표:
		 * - 인터페이스는 "규칙"만 가진다
		 *
		 * 요구사항:
		 * 1) Flyable 인터페이스 정의
		 *    - void fly();
		 *
		 * 2) Bird 클래스
		 *    - Flyable 구현
		 *    - fly()에서 "새가 난다" 출력
		 *
		 * 3) main에서 Bird 객체 생성 후 fly() 호출
		 *
		 * TODO:
		 * - 인터페이스에는 필드/생성자 없음
		 */
		
		Bird bird = new Bird();
		bird.fly();
	}

}
