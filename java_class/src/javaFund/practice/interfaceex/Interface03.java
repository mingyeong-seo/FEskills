package javaFund.practice.interfaceex;

public class Interface03 {

	public static void main(String[] args) {
		/*
		 * [Interface-03] 인터페이스 구현
		 *
		 * 목표:
		 * - implements 사용
		 *
		 * 요구사항:
		 * 1) interface Payment
		 *    - int pay(int amount);
		 *
		 * 2) CardPayment 클래스
		 *    - Payment 구현
		 *    - amount 그대로 반환
		 *
		 * 3) main에서 pay(10000) 호출 후 출력
		 *
		 * TODO:
		 * - 반드시 메서드 구현해야 함
		 */
		
		Payment p1 = new CardPayment();
		
		System.out.println(p1.pay(1000));

	}

}
