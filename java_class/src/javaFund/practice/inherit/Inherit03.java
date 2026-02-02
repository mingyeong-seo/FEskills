package javaFund.practice.inherit;

public class Inherit03 {

	public static void main(String[] args) {
		/*
		 * [Inherit-03] 다형성
		 *
		 * 목표: - 부모 타입으로 자식 객체 참조
		 *
		 * 요구사항: 1) Animal 클래스 + speak() 2) Dog, Cat 클래스 (각각 speak 재정의)
		 *
		 * 3) main에서: - Animal a1 = new Dog(); - Animal a2 = new Cat(); - 각각 speak() 호출
		 *
		 * 관찰 포인트: - 변수 타입이 아니라 "객체 타입" 기준으로 메서드 실행
		 */

		Animal a1 = new Dog();
		Animal a2 = new Cat();
		
		a1.speak();
		a2.speak();

	}

}
