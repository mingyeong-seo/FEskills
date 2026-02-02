package javaFund.practice.inherit;

public class Inherit04 {

	public static void main(String[] args) {
		 /*
	     * [Inherit-04] 상속 관계에서 접근 제한자
	     *
	     * 목표:
	     * - protected 이해
	     *
	     * 요구사항:
	     * 1) Parent 클래스
	     *    - protected int money = 1000;
	     *
	     * 2) Child 클래스 (Parent 상속)
	     *    - showMoney() 메서드에서 money 출력
	     *
	     * 3) main에서 Child 객체 생성 후 showMoney() 호출
	     *
	     * TODO:
	     * - private이면 왜 안 되는지 생각
	     */
		
		Child c1 = new Child();
		c1.showMoney();

	}

}
