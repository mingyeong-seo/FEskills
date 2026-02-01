package javaFund.practice.controlflow.priority;

public class Access04 {

	public static void main(String[] args) {
		/*
		 * [Priority-04] 로그인/권한 접근 제어
		 *
		 * 입력: - boolean isLoggedIn - boolean isBanned (정지 계정 여부) - int level (1~5)
		 *
		 * 규칙(우선순위): 1) 정지 계정(isBanned) 이면 무조건 "BLOCK" (로그인 여부/레벨 무시) 2) 로그인 안 했으면
		 * "LOGIN" 3) 로그인 했으면: - level >= 4 : "ALLOW_ADMIN" - 그 외 : "ALLOW_USER"
		 *
		 * TODO: - isLoggedIn부터 검사하면 isBanned 케이스가 틀리게 처리됨 - 예외(차단) -> 실패(로그인) -> 일반(레벨)
		 * 순으로 구조를 잡아라
		 */

		boolean isLoggedIn = true;
		boolean isBanned = true;
		int level = 1;

		if (isBanned) {
			System.out.println("BLOCK");
			return;
		}

		if (!isLoggedIn) {
			System.out.println("LOGIN");
			return;
		}

		if (level >= 4) {
			System.out.println("ALLOW_ADMIN");
		} else {
			System.out.println("ALLOW_USER");
		}
	}

}
