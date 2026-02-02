package javaFund.practice.interfaceex;

public class Interface04 {
	public static void main(String[] args) {
		/*
		 * [Interface-04] 인터페이스 다형성
		 *
		 * 목표:
		 * - 인터페이스 타입으로 객체 참조
		 *
		 * 요구사항:
		 * 1) interface Animal
		 *    - void sound();
		 *
		 * 2) Dog, Cat 클래스
		 *    - Animal 구현
		 *    - 각각 소리 출력
		 *
		 * 3) main:
		 *    - Animal 타입 변수로 Dog, Cat 받기
		 *    - sound() 호출
		 *
		 * TODO:
		 * - instanceof 사용 금지
		 */
		
		Animal dog = new Dog();
		Animal cat = new Cat();
		
		dog.sound();
		cat.sound();
		}

}
