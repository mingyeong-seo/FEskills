package javaFund.practice.api;

public class Api01_String {

	public static void main(String[] args) {
		 /*
	     * [API-01] String 기본 메서드
	     *
	     * 입력:
	     * - String msg = "Hello Java"
	     *
	     * 요구사항:
	     * 1) msg 길이 출력
	     * 2) "Java" 포함 여부 출력 (true/false)
	     * 3) 전부 대문자로 변환 후 출력
	     *
	     * 출력 예:
	     * length=10
	     * contains=true
	     * upper=HELLO JAVA
	     *
	     * TODO:
	     * - length()
	     * - contains()
	     * - toUpperCase()
	     */
		String msg = "Hello Java";
		
		System.out.println("length="+msg.length());
		System.out.println("contains="+msg.contains("Java"));
		System.out.println("upper="+msg.toUpperCase());

	}

}
