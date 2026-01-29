package javaFund.practice.lib01_string;

/*
 * [문제 String-01] String 기본 + 문서 읽기 체크
 *
 * 목표:
 * 1) == 와 equals() 차이를 "출력 결과"로 확인한다.
 * 2) String 생성 방식 2가지를 비교한다. ("리터럴", new String)
 *
 * 요구사항:
 * 1. String a = "hello";
 * 2. String b = "hello";
 * 3. String c = new String("hello");
 *
 * 아래 3개를 출력하시오.
 * - a == b
 * - a == c
 * - a.equals(c)
 *
 * [오라클 문서 확인 포인트]
 * - String은 immutable(불변)인지 확인
 * - equals()가 무엇을 비교하는지 확인
 */
public class String_01_Basics {
	public static void main(String[] args) {
		String a = "hello";
		String b = "hello";
		String c = new String("hello");

		System.out.println(a == b);
		System.out.println(a == c); // 참조
		System.out.println(a.equals(c)); // 내용

	}
}