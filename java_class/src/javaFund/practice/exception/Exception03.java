package javaFund.practice.exception;

public class Exception03 {

	public static void main(String[] args) {
		/*
		 * [Ex-03] finally 블록
		 *
		 * 목표: - 예외 발생 여부와 상관없이 실행됨
		 *
		 * 요구사항: 1) try에서 int[] arr = {1, 2, 3} 2) arr[5] 접근해서 예외 발생 3) catch에서
		 * "OUT_OF_RANGE" 출력 4) finally에서 "DONE" 출력
		 *
		 * TODO: - ArrayIndexOutOfBoundsException 잡기
		 */

		try {
			int[] arr = { 1, 2, 3 };
			System.out.println(arr[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("OUT_OF_RANGE");

		} finally {
			System.out.println("DONE");
		}

	}

}
