package javaFund.practice.inherit;

public class Inherit05 {

	public static void main(String[] args) {
		/*
	     * [Inherit-05] 추상 클래스
	     *
	     * 목표:
	     * - 추상 메서드 강제 구현
	     *
	     * 요구사항:
	     * 1) abstract class Shape
	     *    - abstract int getArea();
	     *
	     * 2) Rectangle 클래스 (Shape 상속)
	     *    - width, height 필드
	     *    - getArea() 구현
	     *
	     * 3) main에서 Rectangle 객체 생성 후 면적 출력
	     *
	     * TODO:
	     * - Shape 객체 생성 금지
	     */
		
		Rectangle r1 = new Rectangle(10, 5);
        System.out.println(r1.getArea());
	}

}
