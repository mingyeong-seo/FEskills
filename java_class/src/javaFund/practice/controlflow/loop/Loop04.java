package javaFund.practice.controlflow.loop;

public class Loop04 {

	public static void main(String[] args) {
		/*
         * [Loop-04] 비밀번호 입력 시뮬레이션
         *
         * 상황:
         * - 정답 비밀번호는 "1234"
         * - 최대 5번 시도 가능
         *
         * 입력:
         * - String input (코드에서 값 바꿔가며 테스트)
         *
         * 규칙:
         * - 맞으면 "OK" 출력 후 종료
         * - 틀리면 시도 횟수 증가
         * - 5번 실패하면 "LOCK"
         *
         * TODO:
         * 1) while문으로 시도 횟수 관리
         * 2) 성공 시 break
         * 3) 실패 누적
         */
		
		String input="1234";
		String answer = "1234";
		int cnt = 0;
		
		while(cnt <5) {
			if(input.equals(answer)) {
				System.out.println("OK");
				break;
			}
			cnt++;
		}
		System.out.println("LOCK");

	}

}
