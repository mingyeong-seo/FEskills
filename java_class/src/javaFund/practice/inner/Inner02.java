package javaFund.practice.inner;

public class Inner02 {
	public static void main(String[] args) {
		 /*
	     * [Inner-02] static 중첩 클래스
	     *
	     * 목표:
	     * - Outer 객체 없이도 Inner 객체 생성 가능
	     *
	     * 요구사항:
	     * 1) Outer2 클래스 정의
	     *    - static int count = 3;
	     * 2) Outer2 안에 static class Inner2 정의
	     *    - 메서드: printCount()
	     *      -> count 출력
	     * 3) main에서:
	     *    - new Outer2.Inner2() 로 객체 생성
	     *    - printCount() 호출
	     *
	     * TODO:
	     * - Outer2 객체 생성 금지
	     */
		Outer2.Inner2 oi2 = new Outer2.Inner2();
		oi2.printCount(); 
		}
}
