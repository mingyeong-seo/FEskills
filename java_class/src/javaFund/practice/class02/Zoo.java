package javaFund.practice.class02;
/*
 * [문제 5-3]
 * main 메서드를 가진 테스트 클래스
 * 
 * 조건:
 * 1. Animal 타입으로 Dog 객체 생성 후 sound() 호출
 * 2. Animal 타입으로 Bird 객체 생성 후 sound() 호출
 * 3. Fly 타입으로 Bird 객체 생성 후 fly() 호출
 * 
 * ※ instanceof 사용 금지
 */

public class Zoo {
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal bird = new Bird();
		Fly fly = new Bird();

		dog.sound();
		bird.sound();
		fly.fly();

	}
}