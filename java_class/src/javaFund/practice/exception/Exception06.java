package javaFund.practice.exception;

public class Exception06 {
	
	static void check(int money) throws NegativeMoneyException {
		if (money < 0) {
			throw new NegativeMoneyException("money < 0");
		}
	}
	
	public static void main(String[] args) {
		 /*
	     * [Ex-06] 사용자 정의 예외
	     *
	     * 목표:
	     * - Exception 상속
	     *
	     * 요구사항:
	     * 1) NegativeMoneyException 클래스 정의
	     *    - Exception 상속
	     *    - 생성자에서 메시지 받기
	     *
	     * 2) static void check(int money) 메서드
	     *    - money < 0 이면 NegativeMoneyException 발생
	     *
	     * 3) main에서 check(-100) 호출
	     *    - catch해서 "NEGATIVE_MONEY" 출력
	     *
	     * TODO:
	     * - throw + throws 둘 다 사용
	     */
		try {
			check(-100);
		} catch (NegativeMoneyException e) {
			System.out.println("NEGATIVE_MONEY");
		}
		

	}

}
