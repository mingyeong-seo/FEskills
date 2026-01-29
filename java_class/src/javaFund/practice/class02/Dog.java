package javaFund.practice.class02;
/*
 * [문제 4]
 * Dog 클래스는 Animal을 상속받는다.
 * 
 * 조건:
 * 1. 생성자에서 type을 "개"로 초기화한다.
 * 2. sound() 메서드를 오버라이드해서
 *    "멍멍"을 출력한다.
 */

class Dog extends Animal {
	public Dog() {
		super("개");
	}

	@Override
	void sound() {
		System.out.println("멍멍");
	}

}