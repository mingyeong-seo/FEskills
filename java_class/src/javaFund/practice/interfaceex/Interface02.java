package javaFund.practice.interfaceex;

public class Interface02 {

	public static void main(String[] args) {
		/*
		 * [Interface-02] 인터페이스 선언 규칙
		 *
		 * 목표:
		 * - 인터페이스 메서드는 기본적으로 public abstract
		 *
		 * 요구사항:
		 * 1) interface Printable 선언
		 *    - void print();
		 *
		 * 2) Printer 클래스
		 *    - Printable 구현
		 *    - print() → "출력합니다"
		 *
		 * 3) main에서 print 호출
		 *
		 * TODO:
		 * - public abstract 생략 가능 확인
		 */
		
		Printable print = new Printer();
		
		print.print();
		

	}

}
