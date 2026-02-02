package javaFund.practice.inner;

public class Inner01 {
	/*
     * [Inner-01] 인스턴스 내부 클래스
     *
     * 목표:
     * - Outer 객체가 있어야 Inner 객체를 만들 수 있음
     *
     * 요구사항:
     * 1) Outer 클래스 정의
     *    - 필드: String name = "OUTER"
     * 2) Outer 안에 Inner 클래스 정의
     *    - 메서드: printName()
     *      -> Outer의 name 출력
     * 3) main에서:
     *    - Outer 객체 생성
     *    - outer.new Inner() 로 Inner 객체 생성
     *    - printName() 호출
     *
     * TODO:
     * - Inner 클래스는 static 붙이면 안 됨
     */
	public static void main(String[] args) {
		
		Outer out = new Outer();
		
		Outer.Inner inner = out.new Inner();

		
		inner.printName();

		
	}

}
