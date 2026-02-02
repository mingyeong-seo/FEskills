package javaFund.practice.inherit;

public class Inherit02 {

	public static void main(String[] args) {
		 /*
	     * [Inherit-02] 메서드 재정의
	     *
	     * 목표:
	     * - @Override 이해
	     *
	     * 요구사항:
	     * 1) Animal 클래스
	     *    - speak() → "동물이 소리낸다"
	     *
	     * 2) Cat 클래스 (Animal 상속)
	     *    - speak() 재정의
	     *    - "고양이가 야옹한다" 출력
	     *
	     * 3) main에서 Cat 객체로 speak() 호출
	     *
	     * TODO:
	     * - 메서드 시그니처 동일하게 유지
	     */
		
		Cat cat = new Cat();
		cat.speak();

	}

}
