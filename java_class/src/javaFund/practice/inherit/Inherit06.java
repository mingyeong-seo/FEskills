package javaFund.practice.inherit;

public class Inherit06 {

	public static void main(String[] args) {
		/*
	     * [Inherit-06] 객체 배열 + 다형성
	     *
	     * 목표:
	     * - 부모 타입 배열에 자식 객체 저장
	     *
	     * 요구사항:
	     * 1) Animal, Dog, Cat 클래스
	     * 2) Animal[] animals 배열 생성
	     * 3) Dog, Cat 객체 저장
	     * 4) for문으로 speak() 전부 호출
	     *
	     * 관찰 포인트:
	     * - instanceof 없이도 동작함
	     */
		Animal[] animals = new Animal[2];
		
		animals[0] = new Dog();
		animals[1] = new Cat();
		
		for(int i = 0; i < animals.length; i++) {
			animals[i].speak();
			}
	}

}
