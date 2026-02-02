package javaFund.practice.exception;


public class Exception05 {

		  /*
	     * [Ex-05] throws로 예외 떠넘기기
	     *
	     * 목표:
	     * - 메서드 선언부에서 예외 처리 책임 위임
	     *
	     * 요구사항:
	     * 1) static void read() 메서드 작성
	     *    - 내부에서 throw new Exception("fail")
	     *    - 메서드 선언부에 throws Exception
	     *
	     * 2) main에서 read() 호출
	     *    - try/catch로 받아서 "READ_FAIL" 출력
	     *
	     * TODO:
	     * - read()에서는 catch 금지
	     */
		static void read() throws Exception {
			throw new Exception("fail");
		}

		public static void main(String[] args) {

			try {
				read();
			} catch (Exception e) {
				System.out.println("READ_FAIL");
			}
		
	}

}
