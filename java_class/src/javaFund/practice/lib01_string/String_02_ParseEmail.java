package javaFund.practice.lib01_string;

/*
 * [문제 String-02] 이메일 파싱 (split, substring, indexOf)
 *
 * 목표:
 * - split()만 쓰지 말고, indexOf/substring 버전도 만들어본다.
 *
 * 입력:
 * String email = "mingyeongs03@naver.com";
 *
 * 요구사항:
 * 1) split("@")로 id와 domain을 분리해서 출력
 * 2) indexOf("@")를 이용해서 '@' 위치 찾기
 * 3) substring으로 id와 domain을 분리해서 출력
 *
 * 출력 예:
 * id=mingyeongs03
 * domain=naver.com
 *
 * [오라클 문서 확인 포인트]
 * - split의 리턴 타입
 * - substring의 beginIndex/endIndex 규칙
 * - indexOf가 못 찾으면 무엇을 리턴하는지
 */

public class String_02_ParseEmail {
	public static void main(String[] args) {
		String email = "mingyeongs03@naver.com";
		String[] splitSep = email.split("@");
		System.out.println("id="+splitSep[0]);
		System.out.println("domain="+splitSep[splitSep.length-1]);
		int atIndex = email.indexOf("@");
		String id = email.substring(0, atIndex);
		String domain = email.substring(atIndex+1);
		System.out.println("id="+id);
		System.out.println("domain="+domain);
		
		
		
	}
}