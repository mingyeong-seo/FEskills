package javaFund.practice.interfaceex;

public class Interface05 {
	public static void main(String[] args) {
		/*
		 * [Interface-05] default / static 메서드
		 *
		 * 목표:
		 * - 인터페이스도 구현 코드를 가질 수 있다
		 *
		 * 요구사항:
		 * 1) interface Logger
		 *    - default void log() → "로그 출력"
		 *    - static void info() → "정보 출력"
		 *
		 * 2) App 클래스
		 *    - Logger 구현 (메서드 구현 안 해도 됨)
		 *
		 * 3) main:
		 *    - log() 호출
		 *    - Logger.info() 호출
		 *
		 * TODO:
		 * - static은 객체로 호출 ❌
		 */
		
		Logger lo = new App();
		lo.log();
		
		Logger.info();
	}

}
