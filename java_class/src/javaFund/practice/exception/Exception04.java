package javaFund.practice.exception;

public class Exception04 {

	public static void main(String[] args) {
		/*
	     * [Ex-04] throw로 예외 강제 발생
	     *
	     * 입력:
	     * - int age
	     *
	     * 규칙:
	     * - age <= 0 이면 IllegalArgumentException 발생
	     * - 정상 값이면 "OK" 출력
	     *
	     * 요구사항:
	     * 1) if로 조건 검사
	     * 2) throw new IllegalArgumentException(...)
	     * 3) catch에서 "INVALID_AGE" 출력
	     */
		int age = -1;

		try {
			if (age <= 0) {
				throw new IllegalArgumentException();
			}
			System.out.println("OK");

		} catch (IllegalArgumentException e) {
			System.out.println("INVALID_AGE");
		}
	}
}