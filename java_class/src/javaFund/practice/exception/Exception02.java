package javaFund.practice.exception;

public class Exception02 {

	public static void main(String[] args) {
		/*
	     * [Ex-02] try / catch 기본 구조
	     *
	     * 목표:
	     * - 예외를 잡아서 프로그램이 종료되지 않게 함
	     *
	     * 요구사항:
	     * 1) int a = 10, int b = 0
	     * 2) try 블록에서 a / b 실행
	     * 3) ArithmeticException catch
	     *    - "DIVIDE_BY_ZERO" 출력
	     *
	     * TODO:
	     * - catch 타입 정확히 쓰기
	     */
		int a = 10;
		int b = 0;
		try {
			int result = a / b;
		} catch(ArithmeticException e) {
			System.out.println("DIVIDE_BY_ZERO");
		}
	}

}
