package javaFund.practice.class02;
/*
 * [문제 5-2]
 * Bird 클래스는 Animal을 상속받고 Fly를 구현한다.
 * 
 * 조건:
 * 1. 생성자에서 type을 "새"로 초기화한다.
 * 2. sound() → "짹짹" 출력
 * 3. fly()   → "날아간다" 출력
 */

class Bird extends Animal implements Fly {
	public Bird() {
		super("새");
	}

	@Override
	void sound() {
		System.out.println("짹짹");
	}

	@Override
	public void fly() {
		System.out.println("날아간다");

	}
}