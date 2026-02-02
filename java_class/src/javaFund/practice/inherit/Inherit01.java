package javaFund.practice.inherit;

public class Inherit01 {

	public static void main(String[] args) {
		 /*
	     * [Inherit-01] 클래스 상속
	     *
	     * 목표:
	     * - extends 키워드 사용
	     *
	     * 요구사항:
	     * 1) Animal 클래스 정의
	     *    - 필드: name(String)
	     *    - 메서드: speak() → "동물이 소리낸다"
	     *
	     * 2) Dog 클래스 정의 (Animal 상속)
	     *    - main에서 Dog 객체 생성
	     *    - name 설정
	     *    - speak() 호출
	     *
	     * TODO:
	     * - Dog에는 필드/메서드 추가하지 말 것
	     * - 상속만으로 사용
	     */
		Dog dog = new Dog();
		dog.name = "멍멍이";
		dog.speak();

	}

}
